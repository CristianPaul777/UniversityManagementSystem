package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.repository.StudentRepository;
import org.springframework.data.domain.Sort;
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

    public List<Student> getSortedStudents(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(field).ascending()
                : Sort.by(field).descending();

        return repo.findAll(sort);
    }

    public List<Student> getFilteredAndSorted(String name,
                                              String email,
                                              String field,
                                              String direction) {

        List<Student> result;

        if (name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
            result = repo.findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(name, email);
        } else if (name != null && !name.isEmpty()) {
            result = repo.findByNameContainingIgnoreCase(name);
        } else if (email != null && !email.isEmpty()) {
            result = repo.findByEmailContainingIgnoreCase(email);
        } else {
            result = getAllStudents();
        }

        if (field != null && !field.isEmpty()) {
            Sort sort = direction.equalsIgnoreCase("asc")
                    ? Sort.by(field).ascending()
                    : Sort.by(field).descending();

            result = repo.findAll(sort);
        }

        return result;
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
