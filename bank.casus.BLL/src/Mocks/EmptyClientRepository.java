package Mocks;

import Interfaces.IClientRepository;
import Models.Client;
import java.util.LinkedList;
import java.util.List;

public class EmptyClientRepository implements IClientRepository {

    @Override
    public List<Client> getAll() {
        return new LinkedList<>();
    }
}
