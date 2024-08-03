package org.example.hotelmanagement.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.hotelmanagement.entity.HotelEntity;
import org.example.hotelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public String getAllHotels(Model model) {
        List<HotelEntity> hotels = hotelService.getAll();

        model.addAttribute("hotels", hotels);

        return "hotel-list";
    }

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id, Model model){
        HotelEntity hotel = hotelService.getHotelById(id).orElseThrow(
            ()-> new EntityNotFoundException("Hotel not found")
        );

        model.addAttribute("hotel",hotel);

        return "hotel-details";
    }

    @GetMapping("/city/{city}")
    public String getHotelsByCity(@PathVariable String city, Model model){

    }
}
