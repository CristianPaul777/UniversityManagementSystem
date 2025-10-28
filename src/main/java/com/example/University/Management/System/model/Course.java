package com.example.University.Management.System.model;

import java.util.ArrayList;
import java.util.List;

public class Course extends BaseEntity {
    private String id;
    private String title;
    private int credits;
    private String semester;
    private String departmentId;
    private String roomId;
    private List<Enrollment> enrollments;
    private List<TeachingAssignment> assignments;

    public Course(String id, String title, int credits, String semester, String departmentId, String roomId) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.semester = semester;
        this.departmentId = departmentId;
        this.roomId = roomId;
        this.enrollments = new ArrayList<>();
        this.assignments = new ArrayList<>();
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
