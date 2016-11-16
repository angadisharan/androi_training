package com.mathrusoft.teacher.model;

/**
 * Created by sharanangadi on 16/11/16.
 */

public class StudentAttendancePercentage {
    private String name;
    private int presentClasses;
    private float percentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPresentClasses() {
        return presentClasses;
    }

    public void setPresentClasses(int presentClasses) {
        this.presentClasses = presentClasses;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
