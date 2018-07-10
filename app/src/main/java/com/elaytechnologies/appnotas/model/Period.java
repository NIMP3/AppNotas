package com.elaytechnologies.appnotas.model;

public class Period {

    private int codePeriod;
    private String namePeriod;
    private String datePerido;

    public Period(int codePeriod, String namePeriod, String datePerido) {
        this.codePeriod = codePeriod;
        this.namePeriod = namePeriod;
        this.datePerido = datePerido;
    }

    public int getCodePeriod() {
        return codePeriod;
    }

    public void setCodePeriod(int codePeriod) {
        this.codePeriod = codePeriod;
    }

    public String getNamePeriod() {
        return namePeriod;
    }

    public void setNamePeriod(String namePeriod) {
        this.namePeriod = namePeriod;
    }

    public String getDatePerido() {
        return datePerido;
    }

    public void setDatePerido(String datePerido) {
        this.datePerido = datePerido;
    }
}
