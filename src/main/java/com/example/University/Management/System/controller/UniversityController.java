package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.University;
import com.example.University.Management.System.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService service;

    public UniversityController(UniversityService service) {
        this.service = service;
    }

    @GetMapping
    public String index(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String dir,
            Model model
    ) {
        model.addAttribute("universities",
                service.getFilteredAndSorted(name, sort, dir));

        model.addAttribute("name", name);
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);

        return "university/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("university", new University());
        return "university/form";
    }

    @PostMapping
    public String add(
            @Valid @ModelAttribute("university") University university,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "university/form";
        }

        service.addUniversity(university);
        return "redirect:/universities";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("university", service.getUniversityById(id));
        return "university/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("university", service.getUniversityById(id));
        return "university/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(
            @PathVariable String id,
            @Valid @ModelAttribute("university") University university,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "university/edit";
        }

        service.updateUniversity(id, university);
        return "redirect:/universities";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteUniversity(id);
        return "redirect:/universities";
    }
}
