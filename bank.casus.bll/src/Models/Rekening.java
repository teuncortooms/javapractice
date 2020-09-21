package Models;

import Exceptions.SaldoTeLaagException;

import java.math.BigDecimal;
import java.util.UUID;

public class Rekening {
    protected UUID rekeningnummer;
    protected BigDecimal saldo;
    protected BigDecimal minimum;

    public UUID getRekeningnummer() {
        return this.rekeningnummer;
    }
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public Rekening() {
        this.rekeningnummer = UUID.randomUUID();
        this.saldo = BigDecimal.ZERO;
        this.minimum = BigDecimal.ZERO;
    }

    protected void afschrijven(BigDecimal bedrag) throws SaldoTeLaagException {
        BigDecimal newSaldo = this.saldo.subtract(bedrag);
        if (newSaldo.compareTo(this.minimum) < 0)
            throw new SaldoTeLaagException();
        this.saldo = newSaldo;
    }

    protected void bijschrijven(BigDecimal bedrag) {
        this.saldo = this.saldo.add(bedrag);
    }

    @Override
    public String toString() {
        return String.format("Rekening met rekeningnummer %s heeft een saldo van %s euro.",
        rekeningnummer.toString(), saldo.toString());
    }
}