package com.elaytechnologies.appnotas.model;

public class Subject {
    // Atributos propios de la asignatura
    private int codeSubject;
    private String nameSubject;
    private String descriptionSubject;
    // Atributos relacionales
    private int periodSubject;
    private int teacherSubject;

    public Subject(int codeSubject, String nameSubject, String descriptionSubject, int periodSubject, int teacherSubject) {
        this.codeSubject = codeSubject;
        this.nameSubject = nameSubject;
        this.descriptionSubject = descriptionSubject;
        this.periodSubject = periodSubject;
        this.teacherSubject = teacherSubject;
    }

    public int getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(int codeSubject) {
        this.codeSubject = codeSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getDescriptionSubject() {
        return descriptionSubject;
    }

    public void setDescriptionSubject(String descriptionSubject) {
        this.descriptionSubject = descriptionSubject;
    }

    public int getPeriodSubject() {
        return periodSubject;
    }

    public void setPeriodSubject(int periodSubject) {
        this.periodSubject = periodSubject;
    }

    public int getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(int teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}
