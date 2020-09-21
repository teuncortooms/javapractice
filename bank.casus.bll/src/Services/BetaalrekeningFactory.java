package Services;

import Interfaces.IBetaalRekeningFactory;
import Interfaces.ISpaarrekeningFactory;
import Models.Betaalrekening;

import java.math.BigDecimal;

public class BetaalrekeningFactory implements IBetaalRekeningFactory {

    @Override
    public Betaalrekening create(BigDecimal bedrag) {
        return create(bedrag, new SpaarrekeningFactory());
    }

    @Override
    public Betaalrekening create(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory) {
        return new Betaalrekening(bedrag, spaarrekeningFactory);
    }
}
