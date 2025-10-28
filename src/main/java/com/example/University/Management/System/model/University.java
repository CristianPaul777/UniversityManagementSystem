package com.example.University.Management.System.model;

import java.util.ArrayList;
import java.util.List;

public class University extends BaseEntity {
    private String id;
    private String name;
    private String city;
    private String country;
    private List<Department> departments;
    private List<Room> rooms;

    public University() {
        this.departments = new ArrayList<>();
    }

    public University(String id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.departments = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public List<Department> getDepartments() { return departments; }
    public List<Room> getRooms() { return rooms; }
}
