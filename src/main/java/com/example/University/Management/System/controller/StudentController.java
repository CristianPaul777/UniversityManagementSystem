package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Student;
import com.example.University.Management.System.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String add(@Valid @ModelAttribute("student") Student student,
                      BindingResult bindingResult,
                      Model model) {


        if (bindingResult.hasErrors()) {
            return "student/form";
        }


        if (service.emailExists(student.getEmail())) {
            model.addAttribute("error", "A student with this email already exists.");
            return "student/form";
        }

        service.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        Student student = service.getStudentById(id);

        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);
        return "student/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        Student student = service.getStudentById(id);

        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("student") Student student,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            return "student/edit";
        }


        if (service.emailBelongsToAnotherStudent(student.getEmail(), id)) {
            model.addAttribute("error", "Another student already uses this email.");
            return "student/edit";
        }

        service.updateStudent(id, student);
        return "redirect:/students";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
