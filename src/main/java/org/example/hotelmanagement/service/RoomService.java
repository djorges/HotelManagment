package org.example.hotelmanagement.service;

import org.example.hotelmanagement.entity.RoomEntity;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomEntity> getAll();

    Optional<RoomEntity> getRoomById(Long id);

    Optional<RoomEntity> getRoomByRoomNumber(String roomNumber);

    RoomEntity save(RoomEntity room);

    void deleteById(Long id);
}
