package Models;

import Exceptions.RekeningNietGevondenException;
import Exceptions.SaldoTeLaagException;
import Factories.SpaarrekeningFactory;
import Interfaces.ISpaarrekeningFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Betaalrekening extends Rekening {
    private final List<Spaarrekening> spaarrekeningen = new LinkedList<>();
    private final ISpaarrekeningFactory spaarrekeningFactory;

    public Betaalrekening(BigDecimal bedrag) {
        this(bedrag, new SpaarrekeningFactory());
    }

    public Betaalrekening(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory) {
        if (bedrag.compareTo(BigDecimal.ZERO) < 1) throw new IllegalArgumentException(
                "Een betaalrekening kan alleen met een positief bedrag worden geopend.");
        this.saldo = bedrag;
        this.minimum = BigDecimal.valueOf(-500);
        this.spaarrekeningFactory = spaarrekeningFactory;
    }

    public List<Spaarrekening> getSpaarrekeningen(){
        return this.spaarrekeningen;
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public Spaarrekening getSpaarrekening(UUID spaarrekeningNummer) throws RekeningNietGevondenException {
        return this.getSpaarrekeningen().stream()
                .filter((s) -> s.getRekeningnummer() == spaarrekeningNummer)
                .findFirst().orElseThrow(RekeningNietGevondenException::new);
    }

    public void overboeken(BigDecimal bedrag, Betaalrekening tegenrekening)
            throws SaldoTeLaagException, IllegalArgumentException {
        this.afschrijven(bedrag);
        tegenrekening.bijschrijven(bedrag);
    }

    public Spaarrekening aanmakenSpaarrekening() {
        Spaarrekening spaarrekening = this.spaarrekeningFactory.create(this);
        this.spaarrekeningen.add(spaarrekening);
        return spaarrekening;
    }

    public void storten(BigDecimal bedrag) {
        this.bijschrijven(bedrag);
    }

    @Override
    public String toString() {
        return String.format("Betaalrekening met rekeningnummer %s heeft een saldo van %s euro.",
                rekeningnummer.toString(), saldo.toString());
    }
}
