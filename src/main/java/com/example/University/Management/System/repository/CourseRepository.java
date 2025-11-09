package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository extends InFileRepository<Course> {

    public CourseRepository() {
        super("courses.json", Course.class);
    }
}
