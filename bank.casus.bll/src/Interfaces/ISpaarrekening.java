package Interfaces;

import Exceptions.SaldoTeLaagException;
import java.math.BigDecimal;
import java.util.UUID;

public interface ISpaarrekening extends IRekening {

    void opnemen(BigDecimal bedrag) throws SaldoTeLaagException;

    void inleggen(BigDecimal bedrag) throws SaldoTeLaagException;

}
