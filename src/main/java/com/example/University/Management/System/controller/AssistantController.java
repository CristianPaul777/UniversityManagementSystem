package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Assistant;
import com.example.University.Management.System.service.AssistantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assistants")
public class AssistantController {

    private final AssistantService service;

    public AssistantController(AssistantService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("assistants", service.getAllAssistants());
        return "assistant/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assistant", new Assistant());
        return "assistant/form";
    }

    @PostMapping
    public String addAssistant(@ModelAttribute Assistant assistant) {
        service.addAssistant(assistant);
        return "redirect:/assistants";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssistant(@PathVariable String id) {
        service.deleteAssistant(id);
        return "redirect:/assistants";
    }
}
