package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department save(Department department) {
        departments.add(department);
        return department;
    }

    public List<Department> findAll() {
        return new ArrayList<>(departments);
    }

    public Department findById(String id) {
        for (Department d : departments) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return departments.removeIf(d -> d.getId().equals(id));
    }

}
