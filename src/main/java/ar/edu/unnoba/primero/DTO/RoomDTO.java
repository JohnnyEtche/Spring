package ar.edu.unnoba.primero.DTO;

import java.io.Serializable;

public class RoomDTO implements Serializable {
    private long room_id;
    private String name;
    private long price;
    private long availability;
    private String facilities;
    private long occupancy;

    public long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(long id) {
        this.room_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAvailability() {
        return availability;
    }

    public void setAvailability(long availability) {
        this.availability = availability;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public long getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(long occupancy) {
        this.occupancy = occupancy;
    }
}
