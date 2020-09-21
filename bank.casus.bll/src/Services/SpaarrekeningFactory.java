package Services;

import Interfaces.ISpaarrekeningFactory;
import Models.Betaalrekening;
import Models.Spaarrekening;

public class SpaarrekeningFactory implements ISpaarrekeningFactory {
     @Override
     public Spaarrekening create(Betaalrekening betaalrekening){
         return new Spaarrekening(betaalrekening);
     }
}
