package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Course;
import com.example.University.Management.System.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(String id) {
        return repo.findById(id);
    }

    public Course addCourse(Course course) {
        return repo.save(course);
    }


    public Course updateCourse(String id, Course updatedCourse) {
        Course existing = repo.findById(id);
        if (existing != null) {
            updatedCourse.setId(id);
            repo.deleteById(id);
            repo.save(updatedCourse);
            return updatedCourse;
        }
        return null;
    }


    public void deleteCourse(String id) {
        repo.deleteById(id);
    }
}
