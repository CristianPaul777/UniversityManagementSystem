package com.example.University.Management.System.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment extends BaseEntity {

    @Id
    @Column(length = 50)
    private String id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    public Enrollment() {}

    public Enrollment(String id, Student student, Course course, Grade grade) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}
