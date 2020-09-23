import Exceptions.FileReaderException;
import Models.Bank;
import Repositories.ClientRepository;
import Services.BetaalrekeningFactory;
import Services.ClientFactory;
import Services.SpaarrekeningFactory;

import java.io.IOException;

public class CompositionRoot {
    private Bank bank;

    public Bank getBank() {
        return this.bank;
    }

    public CompositionRoot() throws IOException, FileReaderException {
        this.bank = new Bank(
                new ClientRepository("/clients.json"),
                new ClientFactory(
                        new BetaalrekeningFactory(
                                new SpaarrekeningFactory()
                        )
                )
        );
    }
}
