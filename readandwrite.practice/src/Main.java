import java.io.File;

public class Main {

    public static void main(String[] args) {
        // Write a program that reads a file containing text
        // Read each line and send it to the output file, preceded by line numbers

        File inputFile = new File("./readandwrite.practice/resources/inputfile.txt");
        File outputFile = new File("./readandwrite.practice/resources/outputfile.txt");
        new FileContentsCopier(inputFile, outputFile).Run();
    }

}
