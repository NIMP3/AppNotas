package com.elaytechnologies.appnotas.model;

public class User {
    private int codeUser;
    private String idUser;
    private String nameUser;
    private String surnameUser;
    private String avatarUser;
    private String emailUser;

    public User(int codeUser, String idUser, String nameUser, String surnameUser, String avatarUser, String emailUser) {
        this.codeUser = codeUser;
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.surnameUser = surnameUser;
        this.avatarUser = avatarUser;
        this.emailUser = emailUser;
    }

    public int getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(int codeUser) {
        this.codeUser = codeUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getSurnameUser() {
        return surnameUser;
    }

    public void setSurnameUser(String surnameUser) {
        this.surnameUser = surnameUser;
    }

    public String getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(String avatarUser) {
        this.avatarUser = avatarUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
