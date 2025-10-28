package com.example.University.Management.System.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Staff extends BaseEntity {
    private String id;
    private String name;
    private String phoneNumber;
    private List<TeachingAssignment> assignments;

    protected Staff() {
        this.assignments = new ArrayList<>();
    }

    public Staff(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.assignments = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public List<TeachingAssignment> getAssignments() { return assignments; }
}
