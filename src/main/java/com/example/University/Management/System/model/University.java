package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "universities")
public class University extends BaseEntity {

    @Id
    @Column(length = 50)
    @NotBlank(message = "University ID must not be empty")
    @Size(min = 2, max = 50, message = "ID must be between 2 and 50 characters")
    private String id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "University name must not be empty")
    @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters")
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
