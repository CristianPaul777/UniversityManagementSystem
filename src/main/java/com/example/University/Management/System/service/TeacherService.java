package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Teacher;
import com.example.University.Management.System.repository.TeacherRepository;
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

    public Teacher getTeacherById(String id) {
        return repo.findById(id);
    }

    public Teacher addTeacher(Teacher teacher) {
        return repo.save(teacher);
    }


    public Teacher updateTeacher(String id, Teacher updatedTeacher) {
        Teacher existing = repo.findById(id);
        if (existing != null) {
            updatedTeacher.setId(id);
            repo.deleteById(id);
            repo.save(updatedTeacher);
            return updatedTeacher;
        }
        return null;
    }


    public void deleteTeacher(String id) {
        repo.deleteById(id);
    }
}
