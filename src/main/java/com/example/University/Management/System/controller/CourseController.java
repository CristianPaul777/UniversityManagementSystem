package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Course;
import com.example.University.Management.System.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("courses", service.getAllCourses());
        return "course/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("course", new Course());
        return "course/form";
    }

    @PostMapping
    public String addCourse(@ModelAttribute Course course) {
        service.addCourse(course);
        return "redirect:/courses";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable String id) {
        service.deleteCourse(id);
        return "redirect:/courses";
    }
    @GetMapping("/{id}")
    public String showDetails(@PathVariable String id, Model model) {
        model.addAttribute("course", service.getCourseById(id));
        return "course/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("course", service.getCourseById(id));
        return "course/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateCourse(@PathVariable String id, @ModelAttribute Course course) {
        service.updateCourse(id, course);
        return "redirect:/courses";
    }
}
