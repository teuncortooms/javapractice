package Services;

import Interfaces.IBetaalRekeningFactory;
import Interfaces.ISpaarrekeningFactory;
import Models.Betaalrekening;

import java.math.BigDecimal;

public class BetaalrekeningFactory implements IBetaalRekeningFactory {

    private final ISpaarrekeningFactory spaarrekeningFactory;

    public BetaalrekeningFactory(ISpaarrekeningFactory spaarrekeningFactory){
        this.spaarrekeningFactory = spaarrekeningFactory;
    }

    @Override
    public Betaalrekening create(BigDecimal bedrag) {
        return new Betaalrekening(bedrag, this.spaarrekeningFactory);
    }
}
