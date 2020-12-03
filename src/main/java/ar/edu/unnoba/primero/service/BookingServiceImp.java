package ar.edu.unnoba.primero.service;

import ar.edu.unnoba.primero.Modelo.Booking;
import ar.edu.unnoba.primero.Modelo.Room;
import ar.edu.unnoba.primero.repository.BookingRepository;
import ar.edu.unnoba.primero.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BookingServiceImp implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    @Transactional
    public Booking newBooking(Booking booking) throws Exception {
        Room room = this.roomRepository.isRoomAvailable(booking.getCheckIn(),booking.getCheckout(),booking.getRoom().getRoom_id());
        /*if(booking.getCheckIn().before(new Date()) || booking.getCheckIn().after(booking.getCheckout())){
            throw new Exception("Algo ha salido mal pa");
        }*/
        if(room!=null){
            booking.setRoom(room);
            booking.setCost(booking.getRoom().getPrice());
            booking.setCreateAt(new Date());
            booking = bookingRepository.save(booking);
        } else {

            throw new Exception("Algo ha salido mal pa");
        } return booking;
    }
}

