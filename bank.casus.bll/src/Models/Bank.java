package Models;

import Exceptions.ClientNietGevondenException;
import Exceptions.FileReaderException;
import Exceptions.RekeningNietGevondenException;
import Interfaces.*;
import Services.ClientFactory;
import Mocks.EmptyClientRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Bank implements IBank {
    private final IClientFactory clientFactory;
    private List<Client> clients;

    public Bank() throws IOException, FileReaderException {
        this(new EmptyClientRepository(), new ClientFactory());
    }

    public Bank(IClientRepository clientRepository, IClientFactory clientFactory) throws FileReaderException, IOException {
        List<IClientEntity> entities = clientRepository.getAll();
        this.clients = clientFactory.buildList(entities);
        this.clientFactory = clientFactory;
    }

    public Client getClient(UUID clientNummer) throws ClientNietGevondenException {
        return this.clients.stream()
                .filter((c) -> c.getClientNummer() == clientNummer)
                .findFirst().orElseThrow(ClientNietGevondenException::new);
    }

    public List<Client> getAllClients() {
        return this.clients;
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum) {
        Client client = this.clientFactory.buildNew(naam, geboortedatum);
        clients.add(client);
        return client;
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalrekeningFactory) {
        Client client = this.clientFactory.buildNew(naam, geboortedatum, betaalrekeningFactory);
        clients.add(client);
        return client;
    }

    public Betaalrekening findRekening(UUID betaalrekeningNummer) throws ClientNietGevondenException, RekeningNietGevondenException {
        IClient client = findClient(betaalrekeningNummer);
        return client.getBetaalrekening(betaalrekeningNummer);
    }

    private Client findClient(UUID betaalrekeningNummer) throws ClientNietGevondenException {
        for (var client : this.clients) {
            if (clientHasRekening(client, betaalrekeningNummer)) {
                return client;
            }
        }
        throw new ClientNietGevondenException();
    }

    private boolean clientHasRekening(IClient client, UUID betaalrekeningNummer) {
        List<Betaalrekening> rekeningen = client.getBetaalrekeningen();
        for (var rekening : rekeningen) {
            if (rekening.getRekeningnummer() == betaalrekeningNummer) {
                return true;
            }
        }
        return false;
    }
}