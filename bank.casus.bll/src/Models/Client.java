package Models;

import Exceptions.RekeningNietGevondenException;
import Interfaces.IClient;
import Services.BetaalrekeningFactory;
import Interfaces.IBetaalRekeningFactory;
import Interfaces.ISpaarrekeningFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Client implements IClient {
    private final String naam;
    private final LocalDate geboortedatum;
    private final UUID clientNummer;
    private final List<Betaalrekening> betaalrekeningen;
    private final IBetaalRekeningFactory betaalRekeningFactory;

    public UUID getClientNummer() {
        return this.clientNummer;
    }

    public List<Betaalrekening> getBetaalrekeningen() {
        return this.betaalrekeningen;
    }

    public Client() {
        this(null, null);
    }

    public Client(String naam, LocalDate geboortedatum) {
        this(naam, geboortedatum, new BetaalrekeningFactory());
    }

    public Client(String naam, LocalDate geboortedatum, IBetaalRekeningFactory betaalRekeningFactory) {
        this.clientNummer = UUID.randomUUID();
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.betaalrekeningen = new LinkedList<Betaalrekening>();
        this.betaalRekeningFactory = betaalRekeningFactory;
    }

    public Betaalrekening getBetaalrekening(UUID betaalrekeningNummer) throws RekeningNietGevondenException {
        return this.getBetaalrekeningen().stream()
                .filter((c) -> c.getRekeningnummer() == betaalrekeningNummer)
                .findFirst().orElseThrow(RekeningNietGevondenException::new);
    }

    public Betaalrekening openBetaalrekening(BigDecimal bedrag) {
        Betaalrekening nieuweRekening = this.betaalRekeningFactory.create(bedrag);
        this.betaalrekeningen.add(nieuweRekening);
        return nieuweRekening;
    }

    public Betaalrekening openBetaalrekening(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory) {
        Betaalrekening nieuweRekening = this.betaalRekeningFactory.create(bedrag, spaarrekeningFactory);
        this.betaalrekeningen.add(nieuweRekening);
        return nieuweRekening;
    }

}
