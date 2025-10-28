package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Room;
import com.example.University.Management.System.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("rooms", service.getAllRooms());
        return "room/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/form";
    }

    @PostMapping
    public String addRoom(@ModelAttribute Room room) {
        service.addRoom(room);
        return "redirect:/rooms";
    }

    @PostMapping("/{id}/delete")
    public String deleteRoom(@PathVariable String id) {
        service.deleteRoom(id);
        return "redirect:/rooms";
    }
}
