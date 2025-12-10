package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Teacher;
import com.example.University.Management.System.repository.TeacherRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> getAllTeachers() {
        return repo.findAll();
    }

    public List<Teacher> getFilteredAndSortedTeachers(String name, String department, String sortField, String sortDir) {

        Sort sort = sortDir.equals("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        if (!name.isEmpty() && !department.isEmpty()) {
            return repo.findByNameContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(name, department)
                    .stream().sorted((a, b) -> 0).toList();
        }

        if (!name.isEmpty()) {
            return repo.findByNameContainingIgnoreCase(name)
                    .stream().sorted((a, b) -> 0).toList();
        }

        if (!department.isEmpty()) {
            return repo.findByDepartment_NameContainingIgnoreCase(department)
                    .stream().sorted((a, b) -> 0).toList();
        }

        return repo.findAll(sort);
    }

    public Teacher getTeacherById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Teacher addTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    public Teacher updateTeacher(String id, Teacher updatedTeacher) {
        if (repo.existsById(id)) {
            updatedTeacher.setId(id);
            return repo.save(updatedTeacher);
        }
        return null;
    }

    public void deleteTeacher(String id) {
        repo.deleteById(id);
    }
}
