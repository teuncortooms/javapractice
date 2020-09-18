import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Teun", new LocalDate(1985, 9, 6));
        Betaalrekening betaalrekening = client.OpenBetaalrekening();
        Spaarrekening spaarrekening = client.OpenSpaarrekening(betaalrekening);
    }
}
