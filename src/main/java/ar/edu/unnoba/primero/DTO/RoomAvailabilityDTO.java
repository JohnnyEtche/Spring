package ar.edu.unnoba.primero.DTO;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomAvailabilityDTO implements Serializable {
    private String checkin;
    private String checkout;
    private int capacity;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public Date getCheckInDateConverted() throws ParseException {
        return dateFormat.parse(this.checkin);
    }

    public void setCheckInDate(Date checkin) throws ParseException {
        this.checkin = dateFormat.format(checkin);
    }

    public Date getCheckOutDateConverted() throws ParseException {
        return dateFormat.parse(this.checkout);
    }

    public void setCheckOutDate(Date checkout) throws ParseException {
        this.checkout = dateFormat.format(checkout);
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
