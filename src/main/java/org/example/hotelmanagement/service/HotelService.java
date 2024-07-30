package org.example.hotelmanagement.service;

import org.example.hotelmanagement.entity.HotelEntity;

import java.util.List;

public interface HotelService {
    List<HotelEntity> getAll();

    HotelEntity getHotelById(Long id);

    HotelEntity getHotelByCity(String city);

    HotelEntity save(HotelEntity room);

    void deleteById(Long id);
}
