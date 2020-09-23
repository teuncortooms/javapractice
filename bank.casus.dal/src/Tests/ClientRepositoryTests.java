package Tests;

import Exceptions.FileReaderException;
import Exceptions.FileWriterException;
import Interfaces.IClientEntity;
import Repositories.ClientRepository;
import Tests.Mocks.MockClientEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTests {

    @Test
    void getAllFromEmptyFile() {
    }

    @Test
    void getAllFromNonEmptyFile() {
    }

    @Test
    void addClient() {
        ClientRepository r = new ClientRepository("/test.json");
        IClientEntity client = new MockClientEntity();

        try {
            r.addClient(client);
        } catch (FileWriterException | FileReaderException e) {
            fail();
            // integration test: check resource!
        }
    }

    @Test
    void addClientInEmptyFile() {
        ClientRepository r = new ClientRepository("/test.json");
        IClientEntity client = new MockClientEntity();

        try {
            r.addClient(client);
        } catch (FileReaderException | FileWriterException e) {
            fail();
            // integration test: check resource!
        }
    }
}