import Exceptions.FileReaderException;
import Services.ClientFactory;
import Models.Bank;
import Repositories.ClientRepository;

import java.io.File;
import java.io.IOException;

public class BankApp {
    public Bank createBank() throws IOException, FileReaderException {
            return new Bank(
                    new ClientRepository("/clients.json"),
                    new ClientFactory()
            );
    }
}
