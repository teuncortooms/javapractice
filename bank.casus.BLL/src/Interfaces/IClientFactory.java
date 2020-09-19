package Interfaces;

import Models.Client;

import java.time.LocalDate;

public interface IClientFactory {
    Client create(String naam, LocalDate geboortedatum);

    Client create(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalRekeningFactory);
}
