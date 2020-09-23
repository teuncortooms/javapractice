package Mocks;

import Interfaces.IClientEntity;
import Interfaces.IClientRepository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EmptyClientRepository implements IClientRepository {

    @Override
    public List<IClientEntity> getAll() {
        return new LinkedList<>();
    }

    @Override
    public void addClient(IClientEntity client) throws IOException {

    }
}
