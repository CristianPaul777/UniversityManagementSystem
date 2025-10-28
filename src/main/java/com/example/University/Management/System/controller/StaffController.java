package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Staff;
import com.example.University.Management.System.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("staffList", service.getAllStaff());
        return "staff/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("staff", new Staff() {
            @Override
            public String toString() {
                return getName();
            }
        });
        return "staff/form";
    }

    @PostMapping
    public String addStaff(@ModelAttribute Staff staff) {
        service.addStaff(staff);
        return "redirect:/staff";
    }

    @PostMapping("/{id}/delete")
    public String deleteStaff(@PathVariable String id) {
        service.deleteStaff(id);
        return "redirect:/staff";
    }
}
