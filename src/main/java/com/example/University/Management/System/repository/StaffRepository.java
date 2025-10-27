package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Staff;
import java.util.ArrayList;
import java.util.List;

    public class StaffRepository {

        private List<Staff> staffMembers = new ArrayList<>();

        public Staff save(Staff staff) {
            staffMembers.add(staff);
            return staff;
        }

        public List<Staff> findAll() {
            return new ArrayList<>(staffMembers);
        }

        public Staff findById(String id) {
            for (Staff s : staffMembers) {
                if (s.getId().equals(id)) {
                    return s;
                }
            }
            return null;
        }

        public boolean deleteById(String id) {
            return staffMembers.removeIf(s -> s.getId().equals(id));
        }
    }
