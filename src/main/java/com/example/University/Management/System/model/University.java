package com.example.University.Management.System.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "universities")
public class University extends BaseEntity {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Department> departments = new ArrayList<>();

    public University() {}

    public University(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Department> getDepartments() { return departments; }
}
