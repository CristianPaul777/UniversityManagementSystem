package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends InFileRepository<Student> {

    public StudentRepository() {
        super("students.json", Student.class);
    }
}
