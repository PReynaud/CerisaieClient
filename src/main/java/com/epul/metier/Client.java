package com.epul.metier;

/**
 * Created by Pierre on 18/11/2015.
 */
public class Client {
    private int numCli;
    private String nomCli;
    private String adrRueCli;
    private int cpCli;
    private String villeCli;
    private String pieceCli;
    private int numPieceCli;

    public Client(int numCli, String nomCli, String adrRueCli, int cpCli, String villeCli, String pieceCli, int numPieceCli) {
        this.numCli = numCli;
        this.nomCli = nomCli;
        this.adrRueCli = adrRueCli;
        this.cpCli = cpCli;
        this.villeCli = villeCli;
        this.pieceCli = pieceCli;
        this.numPieceCli = numPieceCli;
    }

    public int getNumCli() {
        return numCli;
    }

    public void setNumCli(int numCli) {
        this.numCli = numCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getAdrRueCli() {
        return adrRueCli;
    }

    public void setAdrRueCli(String adrRueCli) {
        this.adrRueCli = adrRueCli;
    }

    public int getCpCli() {
        return cpCli;
    }

    public void setCpCli(int cpCli) {
        this.cpCli = cpCli;
    }

    public String getVilleCli() {
        return villeCli;
    }

    public void setVilleCli(String villeCli) {
        this.villeCli = villeCli;
    }

    public String getPieceCli() {
        return pieceCli;
    }

    public void setPieceCli(String pieceCli) {
        this.pieceCli = pieceCli;
    }

    public int getNumPieceCli() {
        return numPieceCli;
    }

    public void setNumPieceCli(int numPieceCli) {
        this.numPieceCli = numPieceCli;
    }
}
