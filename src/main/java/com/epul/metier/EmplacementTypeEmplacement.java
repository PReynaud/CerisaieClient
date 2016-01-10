package com.epul.metier;

/**
 * Created by Laura on 10/01/2016.
 */
public class EmplacementTypeEmplacement {

    private int numEmpl;
    private int codeTypeE;
    private float surfaceEmpl;
    private int nbPersMaxEmpl;
    private String libtypepl;
    private float tariftypepl;

    public EmplacementTypeEmplacement(int numEmpl, int codeTypeE, float surfaceEmpl, int nbPersMaxEmpl, String libtypepl, float tariftypepl) {
        this.numEmpl = numEmpl;
        this.codeTypeE = codeTypeE;
        this.surfaceEmpl = surfaceEmpl;
        this.nbPersMaxEmpl = nbPersMaxEmpl;
        this.libtypepl = libtypepl;
        this.tariftypepl = tariftypepl;
    }

    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
    }

    public int getCodeTypeE() {
        return codeTypeE;
    }

    public void setCodeTypeE(int codeTypeE) {
        this.codeTypeE = codeTypeE;
    }

    public float getSurfaceEmpl() {
        return surfaceEmpl;
    }

    public void setSurfaceEmpl(float surfaceEmpl) {
        this.surfaceEmpl = surfaceEmpl;
    }

    public int getNbPersMaxEmpl() {
        return nbPersMaxEmpl;
    }

    public void setNbPersMaxEmpl(int nbPersMaxEmpl) {
        this.nbPersMaxEmpl = nbPersMaxEmpl;
    }

    public String getLibtypepl() {
        return libtypepl;
    }

    public void setLibtypepl(String libtypepl) {
        this.libtypepl = libtypepl;
    }

    public float getTariftypepl() {
        return tariftypepl;
    }

    public void setTariftypepl(float tariftypepl) {
        this.tariftypepl = tariftypepl;
    }
}
