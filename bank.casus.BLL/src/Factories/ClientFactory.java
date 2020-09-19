package Factories;

import Interfaces.IBetaalRekeningFactory;
import Models.Client;
import java.time.LocalDate;

public class ClientFactory implements Interfaces.IClientFactory {

    @Override
    public Client create(String naam, LocalDate geboortedatum){
        return create(naam, geboortedatum, new BetaalrekeningFactory());
    }

    @Override
    public Client create(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalrekeningFactory){
        return new Client(naam, geboortedatum, betaalrekeningFactory);
    }
}
