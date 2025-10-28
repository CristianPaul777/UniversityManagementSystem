package com.example.University.Management.System.model;

public class Enrollment {
    private String id;
    private Student student;
    private Course course;
    private Grade grade;

    public Enrollment(String id, Student student, Course course, Grade grade) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public Enrollment() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id='" + id + '\'' +
                ", student=" + (student != null ? student.getName() : "null") +
                ", course=" + (course != null ? course.getTitle() : "null") +
                ", grade=" + grade +
                '}';
    }
}
