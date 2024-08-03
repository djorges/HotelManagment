package org.example.hotelmanagement.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.hotelmanagement.entity.RoomEntity;
import org.example.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public String getAllRooms(Model model){

        model.addAttribute("rooms",roomService.getAll());

        return "room-list";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable Long id, Model model){
        RoomEntity room = roomService.getRoomById(id).orElseThrow(
            () -> new EntityNotFoundException("Invalid room id: " + id)
        );

        model.addAttribute("room",room);

        return "room-details";
    }

    @GetMapping("/room-number/{roomNumber}")
    public String getRoomByNumber(@PathVariable String roomNumber, Model model){
        RoomEntity room = roomService.getRoomByRoomNumber(roomNumber).orElseThrow(
            ()-> new EntityNotFoundException("Invalid room number:" + roomNumber)
        );
        model.addAttribute("room",room);

        return "room-details";
    }

    @GetMapping("/new")
    public String showAddRoomForm(Model model){

        model.addAttribute("room", new RoomEntity());

        return "room-add-form";
    }

    @PostMapping
    public String addRoom(@RequestBody RoomEntity room, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "room-add-form";
        }
        roomService.save(room);
        redirectAttributes.addFlashAttribute("successMessage","Room added successfully");

        return "redirect:/rooms";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoomForm(@PathVariable Long id, Model model){
        RoomEntity room = roomService.getRoomById(id).orElseThrow(
            () -> new EntityNotFoundException("Invalid room id: " + id)
        );
        model.addAttribute("room",room);

        return "room-edit-form";
    }

    @PostMapping("/edit/{id}")
    public String updateRoom(@PathVariable Long id, @RequestBody RoomEntity room, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "room-edit-form";
        }
        room.setId(id);
        roomService.save(room);

        redirectAttributes.addFlashAttribute("successMessage","Room updated successfully");
        return "redirect:/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id, RedirectAttributes redirectAttributes){
        roomService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage","Room deleted successfully");
        return "redirect:/rooms";
    }
}
