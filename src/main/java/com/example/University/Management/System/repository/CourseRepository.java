package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    public Course findById(String id) {
        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return courses.removeIf(c -> c.getId().equals(id));
    }

}

