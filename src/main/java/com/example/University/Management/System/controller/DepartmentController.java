package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Department;
import com.example.University.Management.System.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("departments", service.getAllDepartments());
        return "department/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/form";
    }

    @PostMapping
    public String add(@ModelAttribute Department department) {
        service.addDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("department", service.getDepartmentById(id));
        return "department/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("department", service.getDepartmentById(id));
        return "department/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id, @ModelAttribute Department department) {
        service.updateDepartment(id, department);
        return "redirect:/departments";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteDepartment(id);
        return "redirect:/departments";
    }
}
