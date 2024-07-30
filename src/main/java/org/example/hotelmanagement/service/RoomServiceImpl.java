package org.example.hotelmanagement.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.hotelmanagement.entity.RoomEntity;
import org.example.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomEntity> getAll(){
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity getRoomById(Long id){
        return roomRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Room not found")
        );
    }

    @Override
    public RoomEntity getRoomByRoomNumber(String roomNumber){
        return roomRepository.getRoomByRoomNumber(Long.getLong(roomNumber)).orElseThrow(
            ()-> new EntityNotFoundException("Room not found")
        );
    }

    @Override
    public RoomEntity save(RoomEntity room){
        return roomRepository.save(room);
    }

    @Override
    public void deleteById(Long id){
        roomRepository.deleteById(id);
    }
}
