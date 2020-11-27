package ar.edu.unnoba.primero.DTO;

import java.io.Serializable;

public class RoomDTO implements Serializable {
    private String name;
    private long price;
    private long availability;
    private String facilities;
    private long occupancy;

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
