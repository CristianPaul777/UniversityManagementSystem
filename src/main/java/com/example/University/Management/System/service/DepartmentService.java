package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Department;
import com.example.University.Management.System.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department addDepartment(Department department) {
        return repo.save(department);
    }

    public void deleteDepartment(String id) {
        repo.deleteById(id);
    }
}
