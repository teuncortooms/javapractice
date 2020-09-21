package Interfaces;

import Models.Betaalrekening;
import java.math.BigDecimal;

public interface IBetaalRekeningFactory {
    Betaalrekening create(BigDecimal bedrag);

    Betaalrekening create(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory);
}
