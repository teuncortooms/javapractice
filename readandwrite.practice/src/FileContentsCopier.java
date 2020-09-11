import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileContentsCopier {

    private File outputFile;
    private File inputFile;

    public FileContentsCopier(File input, File output) {
        this.inputFile = input;
        this.outputFile = output;
    }

    public void Run() {
        tryCreate();
        readAndWrite();
    }

    private void tryCreate() {
        try {
            if (this.outputFile.createNewFile()) {
                System.out.println("File created: " + this.outputFile.getName());
            } else {
                System.out.println("File found: " + this.outputFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    private void readAndWrite() {
        try (Scanner inputScanner = new Scanner(this.inputFile);
             FileWriter writer = new FileWriter(this.outputFile)) {
            int lineNumber = 0;
            while (inputScanner.hasNext()) {
                String line = inputScanner.nextLine();
                writer.write(String.format("%d. %s%n", lineNumber++, line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
