package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Assistant;
import com.example.University.Management.System.service.AssistantService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assistants")
public class AssistantController {

    private final AssistantService service;

    public AssistantController(AssistantService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("assistants", service.getAllAssistants());
        return "assistant/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assistant", new Assistant());
        return "assistant/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute("assistant") Assistant assistant,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            return "assistant/form";
        }

        service.addAssistant(assistant);
        return "redirect:/assistants";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        Assistant assistant = service.getAssistantById(id);
        if (assistant == null) {

            return "redirect:/assistants";
        }
        model.addAttribute("assistant", assistant);
        return "assistant/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        Assistant assistant = service.getAssistantById(id);
        if (assistant == null) {
            return "redirect:/assistants";
        }
        model.addAttribute("assistant", assistant);
        return "assistant/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("assistant") Assistant assistant,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {

            return "assistant/edit";
        }

        service.updateAssistant(id, assistant);
        return "redirect:/assistants";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteAssistant(id);
        return "redirect:/assistants";
    }
}