package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Enrollment;
import com.example.University.Management.System.service.EnrollmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("enrollments", service.getAllEnrollments());
        return "enrollment/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        return "enrollment/form";
    }

    @PostMapping
    public String addEnrollment(@ModelAttribute Enrollment enrollment) {
        service.addEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    @PostMapping("/{id}/delete")
    public String deleteEnrollment(@PathVariable String id) {
        service.deleteEnrollment(id);
        return "redirect:/enrollments";
    }
}
