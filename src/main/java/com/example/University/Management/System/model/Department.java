package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    @Id
    @Column(length = 50)
    @NotBlank(message = "ID must not be empty")
    private String id;

    @Column(nullable = false, length = 120)
    @NotBlank(message = "Department name must not be empty")
    @Size(min = 2, max = 120, message = "Department name must be between 2 and 120 characters")
    private String name;

    @Column(nullable = false, length = 120)
    @NotBlank(message = "Faculty name must not be empty")
    @Size(min = 2, max = 120, message = "Faculty name must be between 2 and 120 characters")
    private String faculty;


    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Teacher> teachers = new ArrayList<>();

    public Department() {}

    public Department(String id, String name, String faculty, University university) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.university = university;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public University getUniversity() { return university; }
    public void setUniversity(University university) { this.university = university; }

    public List<Teacher> getTeachers() { return teachers; }
}
