package com.epul.metier;

import java.sql.Timestamp;

/**
 * Created by Pierre on 02/01/2016.
 */
public class Sejour {
    private int numSej;
    private int numCli;
    private int numEmpl;
    private Timestamp datedebSej;
    private Timestamp dateFinSej;
    private int nbPersonnes;

    public Sejour(int numSej, int numCli, int numEmpl, Timestamp datedebSej, Timestamp dateFinSej, int nbPersonnes) {
        this.numSej = numSej;
        this.numCli = numCli;
        this.numEmpl = numEmpl;
        this.datedebSej = datedebSej;
        this.dateFinSej = dateFinSej;
        this.nbPersonnes = nbPersonnes;
    }

    public int getNumSej() {
        return numSej;
    }

    public void setNumSej(int numSej) {
        this.numSej = numSej;
    }

    public int getNumCli() {
        return numCli;
    }

    public void setNumCli(int numCli) {
        this.numCli = numCli;
    }

    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
    }

    public Timestamp getDatedebSej() {
        return datedebSej;
    }

    public void setDatedebSej(Timestamp datedebSej) {
        this.datedebSej = datedebSej;
    }

    public Timestamp getDateFinSej() {
        return dateFinSej;
    }

    public void setDateFinSej(Timestamp dateFinSej) {
        this.dateFinSej = dateFinSej;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }
}
