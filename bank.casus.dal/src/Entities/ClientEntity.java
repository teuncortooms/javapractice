package Entities;

import Interfaces.IClientEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public class ClientEntity implements IClientEntity {
    private UUID clientNummer;
    private String naam;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate geboortedatum;


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
        this.naam = naam;
    }

    @Override
    public void setGeboortedatum(LocalDate datum) {
        this.geboortedatum = datum;
    }

    @Override
    public void setClientNummer(UUID id) {
        this.clientNummer = id;
    }
}
