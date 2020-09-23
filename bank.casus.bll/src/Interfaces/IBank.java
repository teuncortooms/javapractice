package Interfaces;

import Exceptions.ClientNietGevondenException;
import Exceptions.RekeningNietGevondenException;
import Models.Betaalrekening;
import Models.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IBank {
    Client getClient(UUID clientNummer) throws ClientNietGevondenException;
    List<Client> getAllClients();
    Client aanmeldenClient(String naam, LocalDate geboortedatum);
    IClient aanmeldenClient(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalrekeningFactory);
    Betaalrekening findRekening(UUID betaalrekeningNummer) throws ClientNietGevondenException, RekeningNietGevondenException;
}