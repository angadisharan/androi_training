package com.mathrusoft.teacher.model;

/**
 * Created by sharanangadi on 09/11/16.
 */

public class Status {
    private String name;
    private String status;
    private String lastSeen;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }
}
