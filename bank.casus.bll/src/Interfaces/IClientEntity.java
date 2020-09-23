package Interfaces;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.UUID;

public interface IClientEntity {
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate geboortedatum = null;
    
    String getNaam();
    LocalDate getGeboortedatum();
    UUID getClientNummer();

    void setNaam(String naam);
    void setGeboortedatum(LocalDate datum);
    void setClientNummer(UUID id);
}
