package com.example.University.Management.System.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teaching_assignments")
public class TeachingAssignment extends BaseEntity {

    @Id
    @Column(length = 50)
    private String id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssistantRole role;

    public TeachingAssignment() {}

    public TeachingAssignment(String id, Teacher teacher, Course course, AssistantRole role) {
        this.id = id;
        this.teacher = teacher;
        this.course = course;
        this.role = role;
    }

    @Override
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public AssistantRole getRole() { return role; }
    public void setRole(AssistantRole role) { this.role = role; }
}
