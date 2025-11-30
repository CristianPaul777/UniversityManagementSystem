package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Enrollment;
import com.example.University.Management.System.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("enrollments", service.getAllEnrollments());
        return "enrollment/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        return "enrollment/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute("enrollment") Enrollment enrollment,
                      BindingResult bindingResult,
                      Model model) {


        if (bindingResult.hasErrors()) {
            return "enrollment/form";
        }


        if (enrollment.getStudent() == null || enrollment.getCourse() == null) {
            model.addAttribute("error", "Student or course does not exist!");
            return "enrollment/form";
        }

        service.addEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        Enrollment enrollment = service.getEnrollmentById(id);

        if (enrollment == null) {
            return "redirect:/enrollments";
        }

        model.addAttribute("enrollment", enrollment);
        return "enrollment/details";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        Enrollment enrollment = service.getEnrollmentById(id);

        if (enrollment == null) {
            return "redirect:/enrollments";
        }

        model.addAttribute("enrollment", enrollment);
        return "enrollment/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("enrollment") Enrollment enrollment,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            return "enrollment/edit";
        }

        if (enrollment.getStudent() == null || enrollment.getCourse() == null) {
            model.addAttribute("error", "Student or course does not exist!");
            return "enrollment/edit";
        }

        service.updateEnrollment(id, enrollment);
        return "redirect:/enrollments";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteEnrollment(id);
        return "redirect:/enrollments";
    }
}