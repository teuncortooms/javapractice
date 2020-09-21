package Services;

import Interfaces.IBetaalRekeningFactory;
import Interfaces.IClientEntity;
import Models.Client;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ClientFactory implements Interfaces.IClientFactory {

    @Override
    public Client buildNew(String naam, LocalDate geboortedatum) {
        return buildNew(naam, geboortedatum, new BetaalrekeningFactory());
    }

    @Override
    public Client buildNew(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalrekeningFactory) {
        return new Client(naam, geboortedatum, betaalrekeningFactory);
    }

    @Override
    public Client build(IClientEntity clientEntity) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(clientEntity, Client.class);
    }

    @Override
    public List<Client> buildList(List<IClientEntity> entities) {
        List<Client> clients = new LinkedList<>();
        for (var entity : entities) {
            clients.add(this.build(entity));
        }
        return clients;
    }

}
