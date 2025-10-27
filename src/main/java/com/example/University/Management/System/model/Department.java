package com.example.University.Management.System.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private String name;
    private String faculty;
    private List<Course> courses;
    private List<Staff> teachers;

    public Department(String id, String name, String faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
    public List<Course> getCourses() { return courses; }
    public List<Staff> getTeachers() { return teachers; }
}