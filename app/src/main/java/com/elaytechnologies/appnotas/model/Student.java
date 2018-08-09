package com.elaytechnologies.appnotas.model;

public class Student extends User{

    private String gradeStudent;
    private String genderStudent;


    public Student(int codeUser, String idUser, String nameUser, String surnameUser, String avatarUser, String emailUser, String gradeStudent, String genderStudent) {
        super(codeUser, idUser, nameUser, surnameUser, avatarUser, emailUser);

        this.gradeStudent = gradeStudent;
        this.genderStudent = genderStudent;
    }

    public String getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(String gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public String getGenderStudent() {
        return genderStudent;
    }

    public void setGenderStudent(String genderStudent) {
        this.genderStudent = genderStudent;
    }
}

