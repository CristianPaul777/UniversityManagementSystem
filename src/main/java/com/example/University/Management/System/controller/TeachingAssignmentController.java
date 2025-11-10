package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.TeachingAssignment;
import com.example.University.Management.System.service.TeachingAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachingassignments") // URL în browser
public class TeachingAssignmentController {

    private final TeachingAssignmentService service;

    public TeachingAssignmentController(TeachingAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("assignments", service.getAllTeachingAssignments());
        return "teachingassignment/index"; // denumirea folderului
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assignment", new TeachingAssignment());
        return "teachingassignment/form";
    }

    @PostMapping
    public String add(@ModelAttribute TeachingAssignment assignment) {
        service.addTeachingAssignment(assignment);
        return "redirect:/teachingassignments";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("assignment", service.getTeachingAssignmentById(id));
        return "teachingassignment/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("assignment", service.getTeachingAssignmentById(id));
        return "teachingassignment/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id, @ModelAttribute TeachingAssignment assignment) {
        service.updateTeachingAssignment(id, assignment);
        return "redirect:/teachingassignments";
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteTeachingAssignment(id);
        return "redirect:/teachingassignments";
    }
}

