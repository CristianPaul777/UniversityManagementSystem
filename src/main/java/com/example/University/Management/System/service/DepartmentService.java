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

    public Department getDepartmentById(String id) {
        return repo.findById(id);
    }

    public Department addDepartment(Department department) {
        return repo.save(department);
    }


    public Department updateDepartment(String id, Department updatedDepartment) {
        Department existing = repo.findById(id);
        if (existing != null) {
            updatedDepartment.setId(id);
            repo.deleteById(id);
            repo.save(updatedDepartment);
            return updatedDepartment;
        }
        return null;
    }


    public void deleteDepartment(String id) {
        repo.deleteById(id);
    }
}
