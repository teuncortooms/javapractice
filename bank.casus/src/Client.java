import Exceptions.RekeningNietGevondenException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Client {
    @SuppressWarnings({"FieldCanBeLocal", "unused", "RedundantSuppression"})
    private final String naam;
    @SuppressWarnings({"FieldCanBeLocal", "unused", "RedundantSuppression"})
    private final LocalDate geboortedatum;
    private final UUID clientNummer;
    private final List<Betaalrekening> betaalrekeningen;

    public UUID getClientNummer() {
        return this.clientNummer;
    }

    public List<Betaalrekening> getBetaalrekeningen() {
        return this.betaalrekeningen;
    }

    public Client(String naam, LocalDate geboortedatum) {
        this.clientNummer = UUID.randomUUID();
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.betaalrekeningen = new LinkedList<>();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public Betaalrekening getBetaalrekening(UUID betaalrekeningNummer) throws RekeningNietGevondenException {
        return this.getBetaalrekeningen().stream()
                .filter((c) -> c.getRekeningnummer() == betaalrekeningNummer)
                .findFirst().orElseThrow(RekeningNietGevondenException::new);
    }

    public Betaalrekening openBetaalrekening(BigDecimal bedrag) {
        Betaalrekening nieuweRekening = new Betaalrekening(bedrag);
        this.betaalrekeningen.add(nieuweRekening);
        return nieuweRekening;
    }
}
