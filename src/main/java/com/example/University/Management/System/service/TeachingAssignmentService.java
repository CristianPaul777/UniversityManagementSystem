package com.example.University.Management.System.service;

import com.example.University.Management.System.model.TeachingAssignment;
import com.example.University.Management.System.model.Teacher;
import com.example.University.Management.System.model.Course;
import com.example.University.Management.System.repository.TeachingAssignmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TeachingAssignmentService {

    private final TeachingAssignmentRepository repo;

    public TeachingAssignmentService(TeachingAssignmentRepository repo) {
        this.repo = repo;
    }

    public TeachingAssignment getById(String id) {
        return repo.findById(id).orElse(null);
    }

    public TeachingAssignment save(TeachingAssignment ta) {
        return repo.save(ta);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public List<TeachingAssignment> findWithFilterAndSort(
            String teacher,
            String course,
            String role,
            String sortField,
            String sortDir
    ) {
        Specification<TeachingAssignment> spec = Specification.where(null);

        if (teacher != null && !teacher.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("teacher").get("name")), "%" + teacher.toLowerCase() + "%"));
        }

        if (course != null && !course.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("course").get("title")), "%" + course.toLowerCase() + "%"));
        }

        if (role != null && !role.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("role")), "%" + role.toLowerCase() + "%"));
        }

        Sort sort = Sort.by(sortField != null ? sortField : "id");

        if ("desc".equalsIgnoreCase(sortDir)) {
            sort = sort.descending();
        }

        return repo.findAll(spec, sort);
    }
}
