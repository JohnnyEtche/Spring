package ar.edu.unnoba.primero.DTO;

import ar.edu.unnoba.primero.Modelo.Room;
import ar.edu.unnoba.primero.Modelo.User;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfirmBookingRequestDTO {
    private long booking_id;
    private User guest;
    private String checkIn;
    private String checkout;
    private Date createAt;
    private Room room;
    private Boolean breackfastIncluded;
    private Boolean parking;
    private Boolean freeCancelation;
    private float cost;
    public long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(long booking_id) {
        this.booking_id = booking_id;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Boolean getBreackfastIncluded() {
        return breackfastIncluded;
    }

    public void setBreackfastIncluded(Boolean breackfastIncluded) {
        this.breackfastIncluded = breackfastIncluded;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getFreeCancelation() {
        return freeCancelation;
    }

    public void setFreeCancelation(Boolean freeCancelation) {
        this.freeCancelation = freeCancelation;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}