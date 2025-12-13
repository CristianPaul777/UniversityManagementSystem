package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Department;
import com.example.University.Management.System.repository.DepartmentRepository;
import org.springframework.data.domain.Sort;
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

    public List<Department> getAllSorted(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        return repo.findAll(sort);
    }

    public List<Department> filterDepartments(String name, String faculty, String sortField, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        if (!name.isEmpty() && !faculty.isEmpty()) {
            return repo.findByNameContainingIgnoreCaseAndFacultyContainingIgnoreCase(name, faculty);
        }
        if (!name.isEmpty()) {
            return repo.findByNameContainingIgnoreCase(name);
        }
        if (!faculty.isEmpty()) {
            return repo.findByFacultyContainingIgnoreCase(faculty);
        }

        return repo.findAll(sort);
    }

    public Department getDepartmentById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Department addDepartment(Department department) {
        return repo.save(department);
    }

    public Department updateDepartment(String id, Department updatedDepartment) {
        if (repo.existsById(id)) {
            updatedDepartment.setId(id);
            return repo.save(updatedDepartment);
        }
        return null;
    }

    public void deleteDepartment(String id) {
        repo.deleteById(id);
    }
}
