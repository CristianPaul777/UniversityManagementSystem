package com.example.University.Management.System.model;

public class TeachingAssignment extends BaseEntity {

    private String id;
    private String teacherId;
    private String courseId;
    private String role;

    public TeachingAssignment() { }

    public TeachingAssignment(String id, String teacherId, String courseId, String role) {
        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.role = role;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
