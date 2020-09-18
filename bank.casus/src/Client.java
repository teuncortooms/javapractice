import Exceptions.RekeningNietGevondenException;

import javax.accessibility.AccessibleStreamable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID clientNummer;
    private String naam;
    private LocalDate geboortedatum;
    private List<Betaalrekening> betaalrekeningen;

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
        this.betaalrekeningen = new LinkedList<Betaalrekening>();
    }

    public Betaalrekening getBetaalrekening(UUID betaalrekeningNummer) throws RekeningNietGevondenException {
        Betaalrekening betaalrekening = this.getBetaalrekeningen().stream()
                .filter((c) -> c.getRekeningnummer() == betaalrekeningNummer)
                .findFirst().orElseThrow(() -> new RekeningNietGevondenException());
        return betaalrekening;
    }

    public Betaalrekening OpenBetaalrekening() {
        Betaalrekening nieuweRekening = new Betaalrekening(this);
        this.betaalrekeningen.add(nieuweRekening);
        return nieuweRekening;
    }

    public void OpenSpaarrekening(Betaalrekening tegenrekening) {
        if (!this.betaalrekeningen.contains(tegenrekening))
            throw new IllegalArgumentException("Dat is geen valide tegenrekening.");

        tegenrekening.aanmakenSpaarrekening();
    }
}
