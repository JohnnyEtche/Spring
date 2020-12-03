package ar.edu.unnoba.primero.repository;

import ar.edu.unnoba.primero.Modelo.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository <Room,Long>{
    @Query("Select r From Room r where r.occupancy >= :occupancy and r.availability > (Select count(b) From Booking b where b.room = r and b.checkIn between :checkIn and :checkOut)")
    List<Room> getRoomsAvailable(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut, @Param("occupancy") int occupancy );
    @Query("Select r From Room r where r.room_id = :room_id and r.availability > (" + "Select count(b) From Booking b where b.room = r and b.checkIn between :checkIn and :checkOut)")
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)

    Room isRoomAvailable(@Param("checkIn")Date checkIn, @Param("checkOut") Date checkOut, @Param("room_id") Long room_id);
}
