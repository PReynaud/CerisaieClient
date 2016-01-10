package com.epul.metier;

import java.util.ArrayList;

/**
 * Created by Laura on 10/01/2016.
 */
public class Facture {
    private Sejour sejour;
    private ArrayList<Activite> activites;
    private int dureeSejour;
    private int cout;

    public Facture(Sejour sejour, ArrayList<Activite> activites) {
        this.sejour = sejour;
        this.activites = activites;
    }

    private void calculateDuration(){
        //TODO dureeejour = dateFin - dateDeb
    }

    private void calculateCost(){
        int temp = 0;
        for (int i = 0 ; i< activites.size();i++){
            temp += activites.get(i).getSport().getTarifUnite();
        }
    }

}
