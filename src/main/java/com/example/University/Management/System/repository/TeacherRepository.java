package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Teacher;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {

    private List<Teacher> teachers = new ArrayList<>();

    public Teacher save(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public List<Teacher> findAll() {
        return new ArrayList<>(teachers);
    }

    public Teacher findById(String id) {
        for (Teacher t : teachers) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return teachers.removeIf(t -> t.getId().equals(id));
    }

}
