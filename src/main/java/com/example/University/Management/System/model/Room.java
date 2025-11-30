package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {

    @Id
    @Column(length = 50)
    @NotBlank(message = "Room ID must not be empty")
    private String id;

    @Column(nullable = false)
    @Positive(message = "Capacity must be a positive number")
    private double capacity;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "Room number must not be empty")
    @Size(min = 1, max = 20, message = "Room number must be between 1 and 20 characters")
    private String number;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Building must not be empty")
    @Size(min = 2, max = 100, message = "Building must be between 2 and 100 characters")
    private String building;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Room() {}

    public Room(String id, double capacity, String number, String building) {
        this.id = id;
        this.capacity = capacity;
        this.number = number;
        this.building = building;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) { this.capacity = capacity; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }

    public List<Course> getCourses() { return courses; }
}
