package Models;

import Exceptions.ClientNietGevondenException;
import Exceptions.FileReaderException;
import Interfaces.IClientEntity;
import Services.ClientFactory;
import Interfaces.IBetaalRekeningFactory;
import Interfaces.IClientFactory;
import Interfaces.IClientRepository;
import Mocks.EmptyClientRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final IClientFactory clientFactory;
    List<Client> clients;

    public Bank() throws IOException, FileReaderException {
        this(new EmptyClientRepository(), new ClientFactory());
    }

    public Bank(IClientRepository clientRepository, IClientFactory clientFactory) throws FileReaderException, IOException {
        List<IClientEntity> entities = clientRepository.getAll();
        this.clients = clientFactory.buildList(entities);
        this.clientFactory = clientFactory;
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public Client getClient(UUID clientNummer) throws ClientNietGevondenException {
        return this.clients.stream()
                .filter((c) -> c.getClientNummer() == clientNummer)
                .findFirst().orElseThrow(ClientNietGevondenException::new);
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum) {
        Client client = this.clientFactory.buildNew(naam, geboortedatum);
        clients.add(client);
        return client;
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public Client aanmeldenClient(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalrekeningFactory) {
        Client client = this.clientFactory.buildNew(naam, geboortedatum, betaalrekeningFactory);
        clients.add(client);
        return client;
    }
}