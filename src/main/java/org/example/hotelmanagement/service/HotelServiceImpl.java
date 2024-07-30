package org.example.hotelmanagement.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.hotelmanagement.entity.HotelEntity;
import org.example.hotelmanagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelEntity> getAll(){
        return hotelRepository.findAll();
    }

    @Override
    public HotelEntity getHotelById(Long id){
        return hotelRepository.findById(id).orElseThrow(
            ()-> new EntityNotFoundException("Hotel not found")
        );
    }

    @Override
    public HotelEntity getHotelByCity(String city){
        return hotelRepository.getHotelByCity(city).orElseThrow(
            ()-> new EntityNotFoundException("Hotel not found by city")
        );
    }
    @Override
    public HotelEntity save(HotelEntity room){
        return hotelRepository.save(room);
    }

    @Override
    public void deleteById(Long id){
        hotelRepository.deleteById(id);
    }
}
