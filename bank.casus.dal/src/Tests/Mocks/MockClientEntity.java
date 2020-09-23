package Tests.Mocks;

import Interfaces.IClientEntity;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;


public class MockClientEntity implements IClientEntity {
    private String naam;
    private LocalDate geboortedatum;
    private UUID clientNummer;


    public MockClientEntity() {
        String[] names = {"Teun", "Pietje", "Kees", "Truus", "Monique", "Harrie", "Henriette"};
        int i = new Random().nextInt(names.length);

        int y = 1980 + new Random().nextInt(20);
        int m = 1 + new Random().nextInt(12);
        int d = 1 + new Random().nextInt(28);

        this.naam = names[i];
        this.geboortedatum = LocalDate.of(y, m, d);
        this.clientNummer = UUID.randomUUID();
    }

    @Override
    public String getNaam() {
        return this.naam;
    }

    @Override
    public LocalDate getGeboortedatum() {
        return this.geboortedatum;
    }

    @Override
    public UUID getClientNummer() {
        return this.clientNummer;
    }

    @Override
    public void setNaam(String naam) {
    }

    @Override
    public void setGeboortedatum(LocalDate datum) {

    }

    @Override
    public void setClientNummer(UUID id) {

    }
}
