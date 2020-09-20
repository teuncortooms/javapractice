import Exceptions.SaldoTeLaagException;
import Models.Bank;
import Models.Betaalrekening;
import Models.Client;
import Models.Spaarrekening;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // client 1
        Client client1 = bank.aanmeldenClient("Teun",
                LocalDate.of(1985, 9, 6));
        Betaalrekening betaalrekening1 = client1.openBetaalrekening(BigDecimal.ONE);
        // client 2
        Client client2 = bank.aanmeldenClient("Pietje",
                LocalDate.of(1990, 9, 6));
        Betaalrekening betaalrekening2 = client2.openBetaalrekening(BigDecimal.ONE);
        Spaarrekening spaarrekening = betaalrekening2.aanmakenSpaarrekening();

        try {
            // overboeken betaalrekeningen
            betaalrekening1.storten(BigDecimal.valueOf(30.00));
            betaalrekening1.overboeken(BigDecimal.valueOf(60.00), betaalrekening2);

            // inleggen en opnemen spaarrekening
            spaarrekening.inleggen(BigDecimal.valueOf(40.00));
            spaarrekening.opnemen(BigDecimal.valueOf(10.00));
        } catch (SaldoTeLaagException e) {
            System.out.println("Saldo te laag");
        }

        System.out.println(betaalrekening1);
        System.out.println(betaalrekening2);
        System.out.println(spaarrekening);
    }
}
