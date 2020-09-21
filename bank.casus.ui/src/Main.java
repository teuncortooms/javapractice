import Exceptions.FileReaderException;
import Exceptions.SaldoTeLaagException;
import Models.Bank;
import Models.Betaalrekening;
import Models.Client;
import Models.Spaarrekening;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            BankApp app = new BankApp();
            Bank bank = app.createBank();

            // client 1
            Client client1 = bank.aanmeldenClient("Teun",
                    LocalDate.of(1985, 9, 6));
            Betaalrekening betaalrekening1 = client1.openBetaalrekening(BigDecimal.ONE);
            // client 2
            Client client2 = bank.aanmeldenClient("Pietje",
                    LocalDate.of(1990, 9, 6));
            Betaalrekening betaalrekening2 = client2.openBetaalrekening(BigDecimal.ONE);
            Spaarrekening spaarrekening = betaalrekening2.aanmakenSpaarrekening();

            // overboeken betaalrekeningen
            betaalrekening1.storten(BigDecimal.valueOf(30.00));
            betaalrekening1.overboeken(BigDecimal.valueOf(60.00), betaalrekening2);

            // inleggen en opnemen spaarrekening
            spaarrekening.inleggen(BigDecimal.valueOf(40.00));
            spaarrekening.opnemen(BigDecimal.valueOf(10.00));

            System.out.println(betaalrekening1);
            System.out.println(betaalrekening2);
            System.out.println(spaarrekening);

        } catch (IOException | FileReaderException e) {
            System.out.println("Er is een fout opgetreden. " +
                    "Het databestand kan niet worden gelezen. " +
                    "Neem contact op met de beheerder.");
            e.printStackTrace();
        } catch (SaldoTeLaagException e) {
            System.out.println("Saldo te laag");
        }
    }
}
