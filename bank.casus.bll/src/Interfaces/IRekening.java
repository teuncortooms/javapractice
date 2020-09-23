package Interfaces;

import Exceptions.SaldoTeLaagException;

import java.math.BigDecimal;
import java.util.UUID;

public interface IRekening {
    UUID getRekeningnummer();

    BigDecimal getSaldo();

    void afschrijven(BigDecimal bedrag) throws SaldoTeLaagException;

    void bijschrijven(BigDecimal bedrag);
}
