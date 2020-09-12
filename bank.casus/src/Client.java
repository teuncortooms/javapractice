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

    public Client(String naam, LocalDate geboortedatum) {
        this.clientNummer = UUID.randomUUID();
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.betaalrekeningen = new LinkedList<Betaalrekening>();
    }

    public void OpenBetaalrekening() {
        this.betaalrekeningen.add(new Betaalrekening(this));
    }

    public void OpenSpaarrekening(Betaalrekening tegenrekening) {
        if (!this.betaalrekeningen.contains(tegenrekening))
            throw new IllegalArgumentException("Dat is geen valide tegenrekening.");

        tegenrekening.aanmakenSpaarrekening();
    }
}
