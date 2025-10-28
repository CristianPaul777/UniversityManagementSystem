package com.example.University.Management.System.model;

import java.util.ArrayList;
import java.util.List;

public class Room extends BaseEntity {
    private String id;
    private double capacity;
    private String number;
    private String building;
    private List<Course> courses;

    public Room() {
    }

    public Room(String id, double capacity, String number, String building) {
        this.id = id;
        this.capacity = capacity;
        this.number = number;
        this.building = building;
        this.courses = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) { this.capacity = capacity; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }
    public List<Course> getCourses() { return courses; }
}
