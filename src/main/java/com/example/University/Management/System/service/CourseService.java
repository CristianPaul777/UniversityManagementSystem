package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Course;
import com.example.University.Management.System.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public Course updateCourse(String id, Course updatedCourse) {
        Course existing = repo.findById(id).orElse(null);

        if (existing != null) {
            updatedCourse.setId(id);
            return repo.save(updatedCourse);
        }
        return null;
    }

    public void deleteCourse(String id) {
        repo.deleteById(id);
    }
}
