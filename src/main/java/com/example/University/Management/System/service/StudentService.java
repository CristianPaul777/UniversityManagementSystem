package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return repo.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Optional<Student> existing = repo.findById(id);

        if (existing.isPresent()) {
            updatedStudent.setId(id);
            return repo.save(updatedStudent);
        }

        return null;
    }

    public boolean emailExists(String email) {
        return repo.findByEmail(email).isPresent();
    }

    public boolean emailBelongsToAnotherStudent(String email, String id) {
        return repo.findByEmail(email)
                .filter(s -> !s.getId().equals(id))
                .isPresent();
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}


