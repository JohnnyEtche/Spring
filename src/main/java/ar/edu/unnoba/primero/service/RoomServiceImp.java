package ar.edu.unnoba.primero.service;

import ar.edu.unnoba.primero.Modelo.Room;
import ar.edu.unnoba.primero.repository.RoomRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RoomServiceImp implements RoomService {
    private RoomRepository repository;

    public void RoomServiceImp(RoomRepository roomRepository){
        this.repository = roomRepository;
    }

    @Override
    public List<Room> getRoomsAvailable(Date checkIn, Date checkOut, int capacity) {
        return repository.getRoomsAvailable(checkIn, checkOut, capacity);
    }

    @Override
    public Optional<Room> findById(Long roomId) {
        return Optional.empty();
    }
}
