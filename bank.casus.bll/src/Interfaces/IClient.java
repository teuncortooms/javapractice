package Interfaces;

import Exceptions.RekeningNietGevondenException;
import Models.Betaalrekening;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IClient {
    UUID getClientNummer();

    List<Betaalrekening> getBetaalrekeningen();

    Betaalrekening getBetaalrekening(UUID betaalrekeningNummer) throws RekeningNietGevondenException;

    Betaalrekening openBetaalrekening(BigDecimal bedrag);

    Betaalrekening openBetaalrekening(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory);
}
