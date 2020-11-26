package ar.edu.unnoba.primero.service;

import ar.edu.unnoba.primero.Modelo.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getRoomsAvailable(Date checkIn, Date checkOut, int capacity);
    Optional <Room> findById(Long roomId);
}
