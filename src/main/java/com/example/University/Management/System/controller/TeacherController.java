package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Teacher;
import com.example.University.Management.System.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public String index(@RequestParam(defaultValue = "") String name,
                        @RequestParam(defaultValue = "") String department,
                        @RequestParam(defaultValue = "name") String sortField,
                        @RequestParam(defaultValue = "asc") String sortDir,
                        Model model) {

        model.addAttribute("teachers",
                service.getFilteredAndSortedTeachers(name, department, sortField, sortDir));

        model.addAttribute("name", name);
        model.addAttribute("department", department);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSort", sortDir.equals("asc") ? "desc" : "asc");

        return "teacher/index";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute Teacher teacher,
                      BindingResult result,
                      Model model) {

        if (result.hasErrors()) {
            model.addAttribute("teacher", teacher);
            return "teacher/form";
        }

        service.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("teacher", service.getTeacherById(id));
        return "teacher/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("teacher", service.getTeacherById(id));
        return "teacher/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute Teacher teacher,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("teacher", teacher);
            return "teacher/edit";
        }

        service.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
