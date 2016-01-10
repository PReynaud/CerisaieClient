package com.epul.metier;

/**
 * Created by Laura on 10/01/2016.
 */
public class TypeEmplacement {

    private int codeTypeE;
    private String libtypepl;
    private float tariftypepl;

    public TypeEmplacement(int codeTypeE, String libtypepl, float tariftypepl) {
        this.codeTypeE = codeTypeE;
        this.libtypepl = libtypepl;
        this.tariftypepl = tariftypepl;
    }

    public int getCodeTypeE() {
        return codeTypeE;
    }

    public void setCodeTypeE(int codeTypeE) {
        this.codeTypeE = codeTypeE;
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
