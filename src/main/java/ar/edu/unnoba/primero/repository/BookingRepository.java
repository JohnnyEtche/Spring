package ar.edu.unnoba.primero.repository;

import ar.edu.unnoba.primero.Modelo.Booking;
import ar.edu.unnoba.primero.Modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
