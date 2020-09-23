package Interfaces;

import Models.Spaarrekening;

public interface ISpaarrekeningFactory {
    Spaarrekening create(IBetaalrekening betaalrekening);
}
