package com.example.University.Management.System.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false)
    private double capacity;

    @Column(nullable = false, length = 20)
    private String number;

    @Column(nullable = false, length = 20)
    private String building;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Course> courses = new ArrayList<>();

    public Room() {}

    public Room(String id, double capacity, String number, String building) {
        this.id = id;
        this.capacity = capacity;
        this.number = number;
        this.building = building;
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

    public void setCourses(List<Course> courses) { this.courses = courses; }
}
