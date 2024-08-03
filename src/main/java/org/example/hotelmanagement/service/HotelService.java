package org.example.hotelmanagement.service;

import org.example.hotelmanagement.entity.HotelEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<HotelEntity> getAll();

    Optional<HotelEntity> getHotelById(Long id);

    Optional<HotelEntity> getHotelByCity(String city);

    HotelEntity save(HotelEntity room);

    void deleteById(Long id);
}
