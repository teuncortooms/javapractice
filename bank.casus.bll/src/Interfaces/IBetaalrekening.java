package Interfaces;

import Exceptions.RekeningNietGevondenException;
import Exceptions.SaldoTeLaagException;
import Models.Spaarrekening;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IBetaalrekening extends IRekening {

    List<Spaarrekening> getSpaarrekeningen();

    Spaarrekening getSpaarrekening(UUID spaarrekeningNummer) throws RekeningNietGevondenException;

    void overboeken(BigDecimal bedrag, IBetaalrekening tegenrekening)
            throws SaldoTeLaagException, IllegalArgumentException;

    Spaarrekening openSpaarrekening();

    void storten(BigDecimal bedrag);

}