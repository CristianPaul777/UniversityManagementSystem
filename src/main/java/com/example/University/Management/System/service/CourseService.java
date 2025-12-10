package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Course;
import com.example.University.Management.System.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getCoursesFilteredAndSorted(String title, String semester, String sortField, String sortDir) {

        Specification<Course> spec = Specification.where(null);

        if (title != null && !title.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
        }

        if (semester != null && !semester.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("semester"), semester));
        }

        Sort sort = Sort.by(sortField == null ? "title" : sortField);
        sort = sortDir != null && sortDir.equals("desc") ? sort.descending() : sort.ascending();

        return repo.findAll(spec, sort);
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
