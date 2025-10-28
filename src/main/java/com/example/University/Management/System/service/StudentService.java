package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.repository.CRUDrepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class StudentService {

    private final CRUDrepository<Student> studentRepository;

    public StudentService(CRUDrepository<Student> studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
