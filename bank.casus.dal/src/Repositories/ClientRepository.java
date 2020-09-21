package Repositories;

import Entities.ClientEntity;
import Exceptions.FileReaderException;
import Exceptions.FileWriterException;
import Interfaces.IClientEntity;
import Interfaces.IClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class ClientRepository implements IClientRepository {
    private String filename;

    public ClientRepository(String resource) {
        this.filename = resource;
    }

    @Override
    public List<IClientEntity> getAll() throws FileReaderException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = ClientRepository.class.getResourceAsStream(filename);
            return Arrays.asList(mapper.readValue(is, ClientEntity[].class));
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
    }

    @Override
    public void addCLient(IClientEntity client) throws FileReaderException, FileWriterException, JsonProcessingException {
        List<IClientEntity> clients = this.getAll();
        clients.add(client);
        writeToFile(clients);
    }

    private void writeToFile(List<IClientEntity> clients) throws JsonProcessingException, FileWriterException {
//        String clientsAsString = objectsToString(clients);
        String path = ClientRepository.class.getResource(this.filename).getPath();
        File clientsFile = new File(path);

        try /*(FileWriter writer = new FileWriter(clientsFile))*/ {
//            writer.write(clientsAsString);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(clientsFile, clients);
        } catch (IOException e) {
            throw new FileWriterException(e);
        }
    }

    private String objectsToString(List<IClientEntity> clients) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(clients);
    }
}
