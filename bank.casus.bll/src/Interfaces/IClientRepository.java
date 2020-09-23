package Interfaces;

import Exceptions.FileReaderException;
import Exceptions.FileWriterException;

import java.io.IOException;
import java.util.List;

public interface IClientRepository {
    List<IClientEntity> getAll() throws IOException, FileReaderException;
    void addClient(IClientEntity client) throws IOException, FileReaderException, FileWriterException;
}
