import Interfaces.IClientRepository;
import Models.Client;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class ClientRepository implements IClientRepository {

    @Override
    public List<Client> getAll() {
        return new LinkedList<>();
    }
}
