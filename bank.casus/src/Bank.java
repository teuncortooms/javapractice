import Exceptions.ClientNietGevondenException;
import Exceptions.RekeningNietGevondenException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Bank {
    List<Client> clients = new LinkedList<Client>();

    public UUID registerClient(String naam, LocalDate geboortedatum) {
        Client client = new Client(naam, geboortedatum);
        clients.add(client);
        return client.getClientNummer();
    }

    public UUID openBetaalrekening(UUID clientNummer) throws ClientNietGevondenException {
        Client client = getClient(clientNummer);
        Betaalrekening betaalrekening = client.OpenBetaalrekening();
        return betaalrekening.getRekeningnummer();
    }

    public UUID openSpaarrekening(UUID clientNummer, UUID betaalrekeningNummer) throws ClientNietGevondenException, RekeningNietGevondenException {
        Client client = getClient(clientNummer);
        Betaalrekening betaalrekening = client.getBetaalrekening(betaalrekeningNummer);
        Spaarrekening spaarrekening = betaalrekening.aanmakenSpaarrekening();
        return spaarrekening.getRekeningnummer();
    }

    public boolean overboeken(BigDecimal bedrag, UUID van, UUID naar){
        this.get
    }

    private Client getClient(UUID clientNummer) throws ClientNietGevondenException {
        Client client = this.clients.stream()
                .filter((c) -> c.getClientNummer() == clientNummer)
                .findFirst().orElseThrow(() -> new ClientNietGevondenException());
        return client;
    }


}
