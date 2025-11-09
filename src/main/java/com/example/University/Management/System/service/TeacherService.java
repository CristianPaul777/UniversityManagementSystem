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
        updatedTeacher.setId(id);
        return repo.save(updatedTeacher);
    }

    public void deleteTeacher(String id) {
        repo.deleteById(id);
    }
}
