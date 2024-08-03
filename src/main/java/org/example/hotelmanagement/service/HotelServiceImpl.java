package org.example.hotelmanagement.service;

import org.example.hotelmanagement.entity.HotelEntity;
import org.example.hotelmanagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelEntity> getAll(){
        return hotelRepository.findAll();
    }

    @Override
    public Optional<HotelEntity> getHotelById(Long id){
        return hotelRepository.findById(id);
    }

    @Override
    public Optional<HotelEntity> getHotelByCity(String city){
        return hotelRepository.getHotelByCity(city);
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
