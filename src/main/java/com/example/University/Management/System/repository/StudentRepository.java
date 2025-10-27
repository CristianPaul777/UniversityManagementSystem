package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
}
