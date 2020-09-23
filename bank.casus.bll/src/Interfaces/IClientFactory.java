package Interfaces;

import Models.Client;

import java.time.LocalDate;
import java.util.List;

public interface IClientFactory {
    Client buildNew(String naam, LocalDate geboortedatum);

    Client build(IClientEntity clientEntity);

    List<Client> buildList(List<IClientEntity> entities);
}
