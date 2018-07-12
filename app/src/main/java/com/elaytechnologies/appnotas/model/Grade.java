package com.elaytechnologies.appnotas.model;

public class Grade {
    //Atributos propios del grado
    private int codeGrade;
    private String nameGrade;
    private String numberGrade;
    //Atributos relacionales
    private int subjectGrade;

    public Grade(int codeGrade, String nameGrade, int subjectGrade, String numberGrade) {
        this.codeGrade = codeGrade;
        this.nameGrade = nameGrade;
        this.subjectGrade = subjectGrade;
        this.numberGrade = numberGrade;
    }

    public int getCodeGrade() {
        return codeGrade;
    }

    public void setCodeGrade(int codeGrade) {
        this.codeGrade = codeGrade;
    }

    public String getNameGrade() {
        return nameGrade;
    }

    public void setNameGrade(String nameGrade) {
        this.nameGrade = nameGrade;
    }

    public int getSubjectGrade() {
        return subjectGrade;
    }

    public void setSubjectGrade(int subjectGrade) {
        this.subjectGrade = subjectGrade;
    }

    public String getNumberGrade() {
        return numberGrade;
    }

    public void setNumberGrade(String numberGrade) {
        this.numberGrade = numberGrade;
    }
}
