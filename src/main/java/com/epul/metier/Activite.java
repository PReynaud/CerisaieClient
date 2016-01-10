package com.epul.metier;

import java.sql.Timestamp;

/**
 * Created by Laura on 09/01/2016.
 */
public class Activite {

    private String dateJour;
    private int numSej;
    private int nbloc;
    private Sport sport;

    public Activite(String dateJour, int numSej, int nbloc, Sport sport) {
        this.dateJour = dateJour;
        this.numSej = numSej;
        this.nbloc = nbloc;
        this.sport = sport;
    }

    public String getDateJour() {
        return dateJour;
    }

    public void setDateJour(String dateJour) {
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
