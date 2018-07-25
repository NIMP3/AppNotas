package com.elaytechnologies.appnotas.model;

public class Task {

    private int codeTask;
    private String typeTask;
    private String descriptionTask;

    public Task(int codeTask, String typeTask, String descriptionTask) {
        this.codeTask = codeTask;
        this.typeTask = typeTask;
        this.descriptionTask = descriptionTask;
    }

    public int getCodeTask() {
        return codeTask;
    }

    public void setCodeTask(int codeTask) {
        this.codeTask = codeTask;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }
}
