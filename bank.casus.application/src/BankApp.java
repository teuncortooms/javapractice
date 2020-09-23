import Exceptions.*;
import Interfaces.*;
import Models.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

// NIET GEBRUIKT. Poging om communicatie te laten verlopen via use case methodes

public class BankApp {
    Bank bank;

    public BankApp() throws IOException, FileReaderException {
        CompositionRoot root = new CompositionRoot();
        this.bank = root.getBank();
    }

    public UUID aanmeldenClient(String naam, LocalDate geboortedatum) {
        IClient client = bank.aanmeldenClient("Teun",
                LocalDate.of(1985, 9, 6));
        return client.getClientNummer();
    }

    public IBetaalrekening openBetaalrekening(UUID clientNummer, BigDecimal startbedrag) throws ClientNietGevondenException {
        IClient client = bank.getClient(clientNummer);
        return client.openBetaalrekening(BigDecimal.ONE);
    }

    public ISpaarrekening openSpaarrekening(UUID clientNummer, UUID betaalrekeningNummer) throws ClientNietGevondenException, RekeningNietGevondenException {
        IClient client = bank.getClient(clientNummer);
        IBetaalrekening rekening = client.getBetaalrekening(betaalrekeningNummer);
        return rekening.openSpaarrekening();
    }

    public void storten(UUID betaalrekeningNummer, BigDecimal bedrag) throws ClientNietGevondenException, RekeningNietGevondenException {
        IBetaalrekening rekening = bank.findRekening(betaalrekeningNummer);
        rekening.storten(bedrag);
    }

    public void overboeken(UUID betaalrekeningNummer, UUID tegenrekeningNummer, BigDecimal bedrag) throws ClientNietGevondenException, RekeningNietGevondenException, SaldoTeLaagException {
        IBetaalrekening rekening = bank.findRekening(betaalrekeningNummer);
        IBetaalrekening tegenrekening = bank.findRekening(tegenrekeningNummer);
        rekening.overboeken(BigDecimal.valueOf(60.00), tegenrekening);
    }

    public void inleggen(UUID betaalrekeningNummer, UUID spaarrekeningNummer, BigDecimal bedrag) throws ClientNietGevondenException, RekeningNietGevondenException, SaldoTeLaagException {
        IBetaalrekening betaalrekening = bank.findRekening(betaalrekeningNummer);
        ISpaarrekening spaarrekening = betaalrekening.getSpaarrekening(spaarrekeningNummer);
        spaarrekening.inleggen(BigDecimal.valueOf(40.00));
    }

    public void opnemen(UUID betaalrekeningNummer, UUID spaarrekeningNummer, BigDecimal bedrag) throws ClientNietGevondenException, RekeningNietGevondenException, SaldoTeLaagException {
        IBetaalrekening betaalrekening = bank.findRekening(betaalrekeningNummer);
        ISpaarrekening spaarrekening = betaalrekening.getSpaarrekening(spaarrekeningNummer);
        spaarrekening.opnemen(BigDecimal.valueOf(10.00));
    }

}
