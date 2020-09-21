package Entities;

import Interfaces.IClientEntity;
import java.time.LocalDate;
import java.util.UUID;

public class ClientEntity implements IClientEntity {
        private UUID clientNummer;
        private String naam;
        private LocalDate geboortedatum;
}
