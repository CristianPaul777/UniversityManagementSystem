package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository extends InFileRepository<Department> {

    public DepartmentRepository() {
        super("departments.json", Department.class);
    }
}
