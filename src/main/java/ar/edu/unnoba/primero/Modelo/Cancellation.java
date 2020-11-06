package ar.edu.unnoba.primero.Modelo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cancellation")
public class Cancellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cancellation_id;
    @NotNull
    private Date createdAt;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public long getCancellation_id() {
        return cancellation_id;
    }

    public void setCancellation_id(long cancellation_id) {
        this.cancellation_id = cancellation_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
