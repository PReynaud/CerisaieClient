package com.epul.metier;

import java.util.ArrayList;

/**
 * Created by Laura on 10/01/2016.
 */
public class Facture {
private int numSej;
    private int numCli;
    private int numEmpl;
    private String datedebSej;
    private String dateFinSej;
    private int nbPersonnes;
    private int cout;

    public Facture(int numSej, int numCli, int numEmpl, String datedebSej, String dateFinSej, int nbPersonnes, int cout) {
        this.numSej = numSej;
        this.numCli = numCli;
        this.numEmpl = numEmpl;
        this.datedebSej = datedebSej;
        this.dateFinSej = dateFinSej;
        this.nbPersonnes = nbPersonnes;
        this.cout = cout;
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

    public String getDatedebSej() {
        return datedebSej;
    }

    public void setDatedebSej(String datedebSej) {
        this.datedebSej = datedebSej;
    }

    public String getDateFinSej() {
        return dateFinSej;
    }

    public void setDateFinSej(String dateFinSej) {
        this.dateFinSej = dateFinSej;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }
}
