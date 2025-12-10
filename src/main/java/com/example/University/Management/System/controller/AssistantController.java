package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Assistant;
import com.example.University.Management.System.model.AssistantRole;
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
    public String index(@RequestParam(required = false) String name,
                        @RequestParam(required = false) AssistantRole role,
                        @RequestParam(defaultValue = "id") String sort,
                        @RequestParam(defaultValue = "asc") String dir,
                        Model model) {

        model.addAttribute("assistants",
                service.getFilteredAndSorted(name, role, sort, dir));

        model.addAttribute("name", name);
        model.addAttribute("role", role);
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);
        model.addAttribute("roles", AssistantRole.values());

        return "assistant/index";
    }


    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assistant", new Assistant());
        model.addAttribute("roles", AssistantRole.values());
        return "assistant/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute("assistant") Assistant assistant,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", AssistantRole.values());
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
        model.addAttribute("roles", AssistantRole.values());
        return "assistant/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("assistant") Assistant assistant,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", AssistantRole.values());
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
