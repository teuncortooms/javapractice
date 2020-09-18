import Exceptions.SaldoTeLaagException;
import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;
import java.util.List;

public class Betaalrekening extends Rekening {
    private Client eigenaar;
    private List<Spaarrekening> spaarrekeningen;

    public Betaalrekening(Client eigenaar) {
        this.eigenaar = eigenaar;
    }

    public void overboeken(Betaalrekening tegenrekening, BigDecimal bedrag, AfBij afbij)
            throws SaldoTeLaagException, IllegalArgumentException {
        switch (afbij) {
            case BIJ -> overboekenVanTegenrekeningNaarDeze(tegenrekening, bedrag);
            case AF -> overboekenVanDezeNaarTegenrekening(tegenrekening, bedrag);
            default -> throw new IllegalArgumentException(afbij + " is not a known option");
        }
    }

    public Spaarrekening aanmakenSpaarrekening() {
        Spaarrekening spaarrekening =new Spaarrekening(this);
        this.spaarrekeningen.add(spaarrekening);
        return spaarrekening;
    }
}
