package org.beta.vzw.db;

import java.time.LocalDate;
import java.time.Period;

public class Persoon {
    private int id;
    private String voornaam;
    private String achternaam;
    private LocalDate geboortedatum;

    public Persoon(int id, String voornaam, String achternaam, LocalDate geboortedatum) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public int getId() {
        return id;
    }
    public int getLeeftijd(){
        return Period.between(geboortedatum, LocalDate.now()).getYears();
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }
}
