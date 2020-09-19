package Models;

import Exceptions.ClientNietGevondenException;
import Factories.ClientFactory;
import Interfaces.IBetaalRekeningFactory;
import Interfaces.IClientFactory;
import Interfaces.IClientRepository;
import Mocks.EmptyClientRepository;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final IClientFactory clientFactory;
    List<Client> clients = new LinkedList<>();

    public Bank(){
        this(new EmptyClientRepository(), new ClientFactory());
    }

    public Bank(IClientRepository clientRepository, IClientFactory clientFactory){
        this.clients = clientRepository.getAll();
        this.clientFactory = clientFactory;
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public Client getClient(UUID clientNummer) throws ClientNietGevondenException {
        return this.clients.stream()
                .filter((c) -> c.getClientNummer() == clientNummer)
                .findFirst().orElseThrow(ClientNietGevondenException::new);
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum) {
        Client client = this.clientFactory.create(naam, geboortedatum);
        clients.add(client);
        return client;
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalrekeningFactory) {
        Client client = this.clientFactory.create(naam, geboortedatum, betaalrekeningFactory);
        clients.add(client);
        return client;
    }
}