package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Department;
import com.example.University.Management.System.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public String index(@RequestParam(defaultValue = "") String name,
                        @RequestParam(defaultValue = "") String faculty,
                        @RequestParam(defaultValue = "name") String sortField,
                        @RequestParam(defaultValue = "asc") String sortDir,
                        Model model) {

        List<Department> departments = service.filterDepartments(name, faculty, sortField, sortDir);

        model.addAttribute("departments", departments);

        model.addAttribute("name", name);
        model.addAttribute("faculty", faculty);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        return "department/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute("department") Department department,
                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "department/form";
        }

        service.addDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        Department department = service.getDepartmentById(id);

        if (department == null) {
            return "redirect:/departments";
        }

        model.addAttribute("department", department);
        return "department/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        Department department = service.getDepartmentById(id);

        if (department == null) {
            return "redirect:/departments";
        }

        model.addAttribute("department", department);
        return "department/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("department") Department department,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "department/edit";
        }

        service.updateDepartment(id, department);
        return "redirect:/departments";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteDepartment(id);
        return "redirect:/departments";
    }
}
