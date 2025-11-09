package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepository extends InFileRepository<Teacher> {

    public TeacherRepository() {
        super("teachers.json", Teacher.class);
    }
}
