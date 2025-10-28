package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.TeachingAssignment;
import com.example.University.Management.System.service.TeachingAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignments")
public class TeachingAssignmentController {

    private final TeachingAssignmentService service;

    public TeachingAssignmentController(TeachingAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("assignments", service.getAllTeachingAssignments());
        return "assignment/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assignment", new TeachingAssignment());
        return "assignment/form";
    }

    @PostMapping
    public String addAssignment(@ModelAttribute TeachingAssignment assignment) {
        service.addTeachingAssignment(assignment);
        return "redirect:/assignments";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssignment(@PathVariable String id) {
        service.deleteTeachingAssignment(id);
        return "redirect:/assignments";
    }
}
