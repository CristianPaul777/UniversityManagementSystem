package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Staff;
import com.example.University.Management.System.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository repo;

    public StaffService(StaffRepository repo) {
        this.repo = repo;
    }

    public List<Staff> getAllStaff() {
        return repo.findAll();
    }

    public Staff addStaff(Staff staff) {
        return repo.save(staff);
    }

    public void deleteStaff(String id) {
        repo.deleteById(id);
    }
}
