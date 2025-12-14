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
    public String index(@RequestParam(defaultValue = "") String studentId,
                        @RequestParam(defaultValue = "") String courseId,
                        @RequestParam(defaultValue = "id") String sortField,
                        @RequestParam(defaultValue = "asc") String sortDir,
                        Model model) {

        model.addAttribute("enrollments",
                service.getFilteredAndSortedEnrollments(studentId, courseId, sortField, sortDir));

        model.addAttribute("studentId", studentId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSort", sortDir.equals("asc") ? "desc" : "asc");

        return "enrollment/index";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        return "enrollment/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute Enrollment enrollment,
                      BindingResult result,
                      Model model) {

        if (result.hasErrors()) {
            model.addAttribute("enrollment", enrollment);
            return "enrollment/form";
        }

        service.addEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("enrollment", service.getEnrollmentById(id));
        return "enrollment/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("enrollment", service.getEnrollmentById(id));
        return "enrollment/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute Enrollment enrollment,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("enrollment", enrollment);
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