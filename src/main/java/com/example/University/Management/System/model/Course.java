package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Id
    @Column(length = 50)
    @NotBlank(message = "ID must not be empty")
    private String id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Title must not be empty")
    @Size(min = 3, max = 150, message = "Title must be between 3 and 150 characters")
    private String title;

    @Column(nullable = false)
    @Min(value = 1, message = "Credits must be at least 1")
    @Max(value = 30, message = "Credits must be at most 30")
    private int credits;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "Semester must not be empty")
    @Size(max = 20, message = "Semester must be at most 20 characters")
    private String semester;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull(message = "Department must be selected")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @NotNull(message = "Room must be selected")
    private Room room;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingAssignment> assignments = new ArrayList<>();

    public Course() {}

    public Course(String id, String title, int credits, String semester,
                  Department department, Room room) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.semester = semester;
        this.department = department;
        this.room = room;
    }

    @Override
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public List<TeachingAssignment> getAssignments() { return assignments; }
}
