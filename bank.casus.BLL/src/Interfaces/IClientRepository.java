package Interfaces;

import Models.Client;
import java.util.List;

public interface IClientRepository {
    List<Client> getAll();
}
