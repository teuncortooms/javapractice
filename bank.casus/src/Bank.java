import Exceptions.ClientNietGevondenException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Bank {
    List<Client> clients = new LinkedList<>();

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public Client getClient(UUID clientNummer) throws ClientNietGevondenException {
        return this.clients.stream()
                .filter((c) -> c.getClientNummer() == clientNummer)
                .findFirst().orElseThrow(ClientNietGevondenException::new);
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum) {
        Client client = new Client(naam, geboortedatum);
        clients.add(client);
        return client;
    }
}