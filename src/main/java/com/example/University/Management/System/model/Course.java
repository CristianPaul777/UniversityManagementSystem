package com.example.University.Management.System.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private int credits;

    @Column(nullable = false, length = 20)
    private String semester;

    @Column(nullable = false, length = 50)
    private String departmentId;

    @Column(nullable = false, length = 50)
    private String roomId;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingAssignment> assignments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Course() {}

    public Course(String id, String title, int credits, String semester, String departmentId, String roomId) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.semester = semester;
        this.departmentId = departmentId;
        this.roomId = roomId;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public List<TeachingAssignment> getAssignments() { return assignments; }
}
