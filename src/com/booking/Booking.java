package com.booking;
import com.theater.Theater;


public class Booking {
    
    int id;
    String date;
    int seats;
    String seat_type;
    String payment_status;
    Theater theater;
    public Booking(int id, String date, Theater theater) {
        this.id = id;
        this.date = date;
        this.theater = theater;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Theater getTheater() {
        return theater;
    }
    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    



}
   