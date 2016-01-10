package com.epul.metier;

/**
 * Created by Laura on 09/01/2016.
 */
public class Sport {
    private int codeSport;
    private String libelleSport;
    private String uniteTpsSport;
    private int tarifUnite;

    public Sport(int codeSport, String libelleSport, String uniteTpsSport, int tarifUnite) {
        this.codeSport = codeSport;
        this.libelleSport = libelleSport;
        this.uniteTpsSport = uniteTpsSport;
        this.tarifUnite = tarifUnite;
    }

    public int getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    public String getLibelleSport() {
        return libelleSport;
    }

    public void setLibelleSport(String libelleSport) {
        this.libelleSport = libelleSport;
    }

    public String getUniteTpsSport() {
        return uniteTpsSport;
    }

    public void setUniteTpsSport(String uniteTpsSport) {
        this.uniteTpsSport = uniteTpsSport;
    }

    public int getTarifUnite() {
        return tarifUnite;
    }

    public void setTarifUnite(int tarifUnite) {
        this.tarifUnite = tarifUnite;
    }
}
