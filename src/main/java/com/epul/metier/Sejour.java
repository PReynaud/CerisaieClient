package com.epul.metier;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Pierre on 02/01/2016.
 */
public class Sejour {
    private int numSej;
    private int numEmpl;
    private Client client;
    private String datedebSej;
    private String dateFinSej;
    private int nbPersonnes;

    public Sejour(int numSej, Client client, int numEmpl, String datedebSej, String dateFinSej, int nbPersonnes) {
        this.numSej = numSej;
        this.client = client;
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

    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
    }

    public String getDatedebSej() {
        Timestamp timestamp = new Timestamp(Long.parseLong(datedebSej));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());

        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR);
    }

    public void setDatedebSej(String datedebSej) {
        this.datedebSej = datedebSej;
    }

    public String getDateFinSej() {
        Timestamp timestamp = new Timestamp(Long.parseLong(dateFinSej));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());

        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR);
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
