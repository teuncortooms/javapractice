import Exceptions.SaldoTeLaagException;

import java.math.BigDecimal;
import java.util.UUID;

public class Rekening {
    protected UUID rekeningnummer;
    protected BigDecimal saldo;

    public UUID getRekeningnummer() {
        return this.rekeningnummer
    }

    public Rekening() {
        this.rekeningnummer = UUID.randomUUID();
        this.saldo = BigDecimal.ZERO;
    }

    protected void overboekenVanDezeNaarTegenrekening(Betaalrekening tegenrekening, BigDecimal bedrag)
            throws SaldoTeLaagException {
        this.afschrijven(bedrag);
        tegenrekening.bijschrijven(bedrag);
    }

    protected void overboekenVanTegenrekeningNaarDeze(Betaalrekening tegenrekening, BigDecimal bedrag)
            throws SaldoTeLaagException {
        tegenrekening.afschrijven(bedrag);
        this.bijschrijven(bedrag);
    }

    protected void afschrijven(BigDecimal amount) throws SaldoTeLaagException {
        BigDecimal newSaldo = this.saldo.subtract(amount);
        if (newSaldo.compareTo(BigDecimal.ZERO) == -1)
            throw new SaldoTeLaagException();
        this.saldo = newSaldo;
    }

    protected void bijschrijven(BigDecimal amount) {
        this.saldo = this.saldo.add(amount);
    }
}