package Interfaces;

import Models.Betaalrekening;
import Models.Spaarrekening;

public interface ISpaarrekeningFactory {
    Spaarrekening create(Betaalrekening betaalrekening);
}
