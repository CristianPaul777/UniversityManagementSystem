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
    public String index(@RequestParam(defaultValue = "") String name,
                        @RequestParam(defaultValue = "") String email,
                        @RequestParam(defaultValue = "id") String sortField,
                        @RequestParam(defaultValue = "asc") String sortDir,
                        Model model) {

        model.addAttribute("students",
                service.getFilteredAndSortedStudents(name, email, sortField, sortDir));

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSort", sortDir.equals("asc") ? "desc" : "asc");

        return "student/index";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute Student student,
                      BindingResult result,
                      Model model) {

        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "student/form";
        }

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
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute Student student,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("student", student);
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
