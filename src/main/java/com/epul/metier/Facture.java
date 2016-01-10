package com.epul.metier;

import com.epul.metier.*;

import java.util.List;

/**
 * Created by Laura on 10/01/2016.
 */
public class Facture {
    private Sejour sejourClient;
    private Emplacement emplacement;
    private TypeEmplacement typeEmplacement;
    private List<Activite> activiteSport;
    private float prix;
    private float prixActivite;
    private float prixSejour;

    public Facture(Sejour sejourClient, Emplacement emplacement, TypeEmplacement typeEmplacement, List<Activite> activiteSport, float prix, float prixActivite, float prixSejour) {
        this.sejourClient = sejourClient;
        this.emplacement = emplacement;
        this.typeEmplacement = typeEmplacement;
        this.activiteSport = activiteSport;
        this.prix = prix;
        this.prixActivite = prixActivite;
        this.prixSejour = prixSejour;
    }

    public Sejour getSejourClient() {
        return sejourClient;
    }

    public void setSejourClient(Sejour sejourClient) {
        this.sejourClient = sejourClient;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public TypeEmplacement getTypeEmplacement() {
        return typeEmplacement;
    }

    public void setTypeEmplacement(TypeEmplacement typeEmplacement) {
        this.typeEmplacement = typeEmplacement;
    }

    public List<Activite> getActiviteSport() {
        return activiteSport;
    }

    public void setActiviteSport(List<Activite> activiteSport) {
        this.activiteSport = activiteSport;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrixActivite() {
        return prixActivite;
    }

    public void setPrixActivite(float prixActivite) {
        this.prixActivite = prixActivite;
    }

    public float getPrixSejour() {
        return prixSejour;
    }

    public void setPrixSejour(float prixSejour) {
        this.prixSejour = prixSejour;
    }
}
