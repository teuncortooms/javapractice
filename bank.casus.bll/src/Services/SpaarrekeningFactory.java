package Services;

import Interfaces.*;
import Models.Spaarrekening;

public class SpaarrekeningFactory implements ISpaarrekeningFactory {
     @Override
     public Spaarrekening create(IBetaalrekening betaalrekening){
         return new Spaarrekening(betaalrekening);
     }
}
