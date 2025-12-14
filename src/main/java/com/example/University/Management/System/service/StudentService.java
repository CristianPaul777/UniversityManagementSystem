package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.repository.StudentRepository;
import org.springframework.data.domain.Sort;
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

    public List<Student> getFilteredAndSortedStudents(
            String name,
            String email,
            String sortField,
            String sortDir
    ) {

        Sort sort = sortDir.equals("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        if (!name.isEmpty() && !email.isEmpty()) {
            return repo.findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(name, email)
                    .stream().sorted((a, b) -> 0).toList();
        }

        if (!name.isEmpty()) {
            return repo.findByNameContainingIgnoreCase(name)
                    .stream().sorted((a, b) -> 0).toList();
        }

        if (!email.isEmpty()) {
            return repo.findByEmailContainingIgnoreCase(email)
                    .stream().sorted((a, b) -> 0).toList();
        }

        return repo.findAll(sort);
    }

    public Student getStudentById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        if (repo.existsById(id)) {
            updatedStudent.setId(id);
            return repo.save(updatedStudent);
        }
        return null;
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}
