package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(String id) {
        return repo.findById(id);
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Student existing = repo.findById(id);
        if (existing != null) {
            updatedStudent.setId(id);
            repo.deleteById(id);
            repo.save(updatedStudent);
            return updatedStudent;
        }
        return null;
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}
