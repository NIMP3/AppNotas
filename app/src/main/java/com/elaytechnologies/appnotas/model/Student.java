package com.elaytechnologies.appnotas.model;

public class Student {

    private int codeStudent;
    private String idStudent;
    private String nameStudent;
    private String surnameStudent;
    private String gradeStudent;
    private String emailStudent;

    public Student(int codeStudent, String idStudent, String nameStudent, String surnameStudent, String gradeStudent, String emailStudent) {
        this.codeStudent = codeStudent;
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.surnameStudent = surnameStudent;
        this.gradeStudent = gradeStudent;
        this.emailStudent = emailStudent;
    }

    public int getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(int codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSurnameStudent() {
        return surnameStudent;
    }

    public void setSurnameStudent(String surnameStudent) {
        this.surnameStudent = surnameStudent;
    }

    public String getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(String gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }
}
