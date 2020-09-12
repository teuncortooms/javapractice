import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Teun", new LocalDate(1985, 9, 6));
        client.OpenBetaalrekening();
    }
}
