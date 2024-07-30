package org.example.hotelmanagement.controller;

import org.example.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public String getAllRooms(){

    }
}
