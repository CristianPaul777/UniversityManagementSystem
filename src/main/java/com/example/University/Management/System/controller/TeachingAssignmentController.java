package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.TeachingAssignment;
import com.example.University.Management.System.service.TeachingAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachingassignments")
public class TeachingAssignmentController {

    private final TeachingAssignmentService service;

    public TeachingAssignmentController(TeachingAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("teachingassignments", service.getAllTeachingAssignments());
        return "teachingassignments/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("teachingAssignment", new TeachingAssignment());
        return "teachingassignments/form";
    }

    @PostMapping
    public String addTeachingAssignment(@ModelAttribute TeachingAssignment teachingAssignment) {
        service.addTeachingAssignment(teachingAssignment);
        return "redirect:/teachingassignments";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeachingAssignment(@PathVariable String id) {
        service.deleteTeachingAssignment(id);
        return "redirect:/teachingassignments";
    }
}
