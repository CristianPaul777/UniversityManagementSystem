package com.example.University.Management.System.controller;

import com.example.University.Management.System.model.Room;
import com.example.University.Management.System.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public String index(@RequestParam(required = false) String sort,
                        @RequestParam(required = false) String order,
                        @RequestParam(required = false) String numberFilter,
                        @RequestParam(required = false) String buildingFilter,
                        Model model) {

        model.addAttribute("rooms",
                service.getAllRooms(sort, order, numberFilter, buildingFilter));

        model.addAttribute("numberFilter", numberFilter);
        model.addAttribute("buildingFilter", buildingFilter);
        model.addAttribute("sort", sort);
        model.addAttribute("order", order);

        return "room/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/form";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute("room") Room room,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            return "room/form";
        }

        if (room.getCapacity() <= 0) {
            model.addAttribute("error", "Capacity must be greater than 0.");
            return "room/form";
        }

        service.addRoom(room);
        return "redirect:/rooms";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        Room room = service.getRoomById(id);

        if (room == null) {
            return "redirect:/rooms";
        }

        model.addAttribute("room", room);
        return "room/details";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        Room room = service.getRoomById(id);

        if (room == null) {
            return "redirect:/rooms";
        }

        model.addAttribute("room", room);
        return "room/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("room") Room room,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            return "room/edit";
        }

        if (room.getCapacity() <= 0) {
            model.addAttribute("error", "Capacity must be greater than 0.");
            return "room/edit";
        }

        service.updateRoom(id, room);
        return "redirect:/rooms";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.deleteRoom(id);
        return "redirect:/rooms";
    }
}
