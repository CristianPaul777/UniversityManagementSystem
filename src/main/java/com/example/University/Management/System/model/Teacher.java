package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @Id
    @Column(length = 50)
    @NotBlank(message = "Teacher ID must not be empty")
    private String id;

    @Column(nullable = false, length = 120)
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 120, message = "Name must be between 2 and 120 characters")
    private String name;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "Phone number must not be empty")
    @Pattern(
            regexp = "^[0-9+ ]{7,20}$",
            message = "Phone number must contain only digits, + or spaces (7–20 characters)"
    )
    private String phoneNumber;

    @Column(name = "`rank`", nullable = false, length = 50)
    @NotBlank(message = "Rank must not be empty")
    @Size(min = 2, max = 50, message = "Rank must be between 2 and 50 characters")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingAssignment> assignments = new ArrayList<>();

    public Teacher() {}

    public Teacher(String id, String name, String phoneNumber, String rank, Department department) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rank = rank;
        this.department = department;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<TeachingAssignment> getAssignments() { return assignments; }
}