package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "student/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping
    public String addStudent(@ModelAttribute Student student) {
        service.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "student/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "student/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id, @ModelAttribute Student student) {
        service.updateStudent(id, student);
        return "redirect:/students";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
