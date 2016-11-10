package com.mathrusoft.teacher.model;

/**
 * Created by sharanangadi on 10/11/16.
 */

public class Student {
    private String name;
    private String usn;
    private String branch;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
