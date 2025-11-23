package com.example.University.Management.System.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String rank;

    @Column(nullable = false, length = 50)
    private String departmentId;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingAssignment> assignments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Teacher() {}

    public Teacher(String id, String name, String phoneNumber, String rank, String departmentId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rank = rank;
        this.departmentId = departmentId;
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

    public String getRank() { return rank; }

    public void setRank(String rank) { this.rank = rank; }

    public String getDepartmentId() { return departmentId; }

    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

    public List<TeachingAssignment> getAssignments() { return assignments; }
}
