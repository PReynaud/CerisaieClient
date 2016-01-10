package com.epul.metier;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Laura on 09/01/2016.
 */
public class Activite {

    private String dateJour;
    //private String timestamp;
    private int numSej;
    private int nbloc;
    private Sport sport;

    public Activite(String dateJour, int numSej, int nbloc, Sport sport) {
        this.dateJour = dateJour;
        this.numSej = numSej;
        this.nbloc = nbloc;
        this.sport = sport;
     //   calculateTimestamp();
    }

    public String getDateJour() {
        Timestamp timestamp = new Timestamp(Long.parseLong(dateJour));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());

        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(calendar.YEAR);
    }

    public String calculateTimestamp(){
        Timestamp timestamp = new Timestamp(Long.parseLong(dateJour));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());

        return  calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(calendar.YEAR) + "-" + calendar.get(Calendar.HOUR_OF_DAY);
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
