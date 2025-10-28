package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Teacher;
import com.example.University.Management.System.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("teachers", service.getAllTeachers());
        return "teacher/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/form";
    }

    @PostMapping
    public String addTeacher(@ModelAttribute Teacher teacher) {
        service.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeacher(@PathVariable String id) {
        service.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
