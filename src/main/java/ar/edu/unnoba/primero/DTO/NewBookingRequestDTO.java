package ar.edu.unnoba.primero.DTO;

import java.text.SimpleDateFormat;

public class NewBookingRequestDTO {
        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        private long roomId;
        private String CheckIn;
        private String CheckOut;
        private int occupancy;

        public static SimpleDateFormat getDateFormat() {
            return dateFormat;
        }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getCheckIn() {
            return CheckIn;
        }

        public void setCheckIn(String checkIn) {
            CheckIn = checkIn;
        }

        public String getCheckOut() {
            return CheckOut;
        }

        public void setCheckOut(String checkOut) {
            CheckOut = checkOut;
        }

        public int getOccupancy() {
            return occupancy;
        }

        public void setOccupancy(int occupancy) {
            this.occupancy = occupancy;
        }
    }


