package Models;

import Exceptions.SaldoTeLaagException;
import Interfaces.IRekening;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Rekening implements IRekening {
    protected UUID rekeningnummer;
    protected BigDecimal saldo;
    protected BigDecimal minimum;

    @Override
    public UUID getRekeningnummer() {
        return this.rekeningnummer;
    }

    @Override
    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public Rekening() {
        this.rekeningnummer = UUID.randomUUID();
        this.saldo = BigDecimal.ZERO;
        this.minimum = BigDecimal.ZERO;
    }

    @Override
    public void afschrijven(BigDecimal bedrag) throws SaldoTeLaagException {
        BigDecimal newSaldo = this.saldo.subtract(bedrag);
        if (newSaldo.compareTo(this.minimum) < 0)
            throw new SaldoTeLaagException();
        this.saldo = newSaldo;
    }

    @Override
    public void bijschrijven(BigDecimal bedrag) {
        this.saldo = this.saldo.add(bedrag);
    }

    @Override
    public String toString() {
        return String.format("Rekening met rekeningnummer %s heeft een saldo van %s euro.",
        rekeningnummer.toString(), saldo.toString());
    }
}