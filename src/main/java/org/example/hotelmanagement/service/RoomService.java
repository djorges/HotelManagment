package org.example.hotelmanagement.service;

import org.example.hotelmanagement.entity.RoomEntity;

import java.util.List;

public interface RoomService {
    List<RoomEntity> getAll();

    RoomEntity getRoomById(Long id);

    RoomEntity getRoomByRoomNumber(String roomNumber);

    RoomEntity save(RoomEntity room);

    void deleteById(Long id);
}
