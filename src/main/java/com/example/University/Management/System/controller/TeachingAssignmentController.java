package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.TeachingAssignment;
import com.example.University.Management.System.service.TeachingAssignmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachingassignments")
public class TeachingAssignmentController {

    private final TeachingAssignmentService service;

    public TeachingAssignmentController(TeachingAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public String index(
            @RequestParam(required = false) String teacher,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String role,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model
    ) {
        model.addAttribute("assignments",
                service.findWithFilterAndSort(teacher, course, role, sortField, sortDir));

        model.addAttribute("teacherFilter", teacher);
        model.addAttribute("courseFilter", course);
        model.addAttribute("roleFilter", role);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        return "teachingassignment/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assignment", new TeachingAssignment());
        return "teachingassignment/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute("assignment") TeachingAssignment assignment,
                      BindingResult result) {
        if (result.hasErrors()) {
            return "teachingassignment/form";
        }
        service.save(assignment);
        return "redirect:/teachingassignments";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("assignment", service.getById(id));
        return "teachingassignment/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("assignment", service.getById(id));
        return "teachingassignment/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("assignment") TeachingAssignment assignment,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "teachingassignment/edit";
        }

        assignment.setId(id);
        service.save(assignment);

        return "redirect:/teachingassignments";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/teachingassignments";
    }
}
