package com.epul.metier;

import java.sql.Timestamp;

/**
 * Created by Laura on 09/01/2016.
 */
public class Activite {
    private int codeSport;
    private Timestamp dateJour;
    private int numSej;
    private int nbloc;
    private String sport;
    private String tarif;
    private String unite;

    public Activite(int codeSport, Timestamp dateJour, int numSej, int nbloc, String sport, String tarif, String unite) {
        this.codeSport = codeSport;
        this.dateJour = dateJour;
        this.numSej = numSej;
        this.nbloc = nbloc;
        this.sport = sport;
        this.tarif = tarif;
        this.unite = unite;
    }

    public int getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    public Timestamp getDateJour() {
        return dateJour;
    }

    public void setDateJour(Timestamp dateJour) {
        this.dateJour = dateJour;
    }

    public int getNumSej() {
        return numSej;
    }

    public void setNumSej(int numSej) {
        this.numSej = numSej;
    }

    public int getNbloc() {
        return nbloc;
    }

    public void setNbloc(int nbloc) {
        this.nbloc = nbloc;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
