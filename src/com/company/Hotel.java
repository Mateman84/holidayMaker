package com.company;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms = new ArrayList<Room>();
    private String hotelName;
    private String hotelLocation;
    private Boolean hasPool;
    private Boolean hasEveningEntertainment;
    private Boolean hasChildrensClub;
    private Boolean hasRestaurant;

    public Hotel(ArrayList<Room> rooms, String hotelName, String hotelLocation, Boolean hasPool, Boolean hasEveningEntertainment, Boolean hasChildrensClub, Boolean hasRestaurant) {
        this.rooms = rooms;
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.hasPool = hasPool;
        this.hasEveningEntertainment = hasEveningEntertainment;
        this.hasChildrensClub = hasChildrensClub;
        this.hasRestaurant = hasRestaurant;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    public Boolean getHasEveningEntertainment() {
        return hasEveningEntertainment;
    }

    public void setHasEveningEntertainment(Boolean hasEveningEntertainment) {
        this.hasEveningEntertainment = hasEveningEntertainment;
    }

    public Boolean getHasChildrensClub() {
        return hasChildrensClub;
    }

    public void setHasChildrensClub(Boolean hasChildrensClub) {
        this.hasChildrensClub = hasChildrensClub;
    }

    public Boolean getHasRestaurant() {
        return hasRestaurant;
    }

    public void setHasRestaurant(Boolean hasRestaurant) {
        this.hasRestaurant = hasRestaurant;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" + rooms +
                ", hotelName='" + hotelName + '\'' +
                ", hotelLocation='" + hotelLocation + '\'' +
                ", hasPool=" + hasPool +
                ", hasEveningEntertainment=" + hasEveningEntertainment +
                ", hasChildrensClub=" + hasChildrensClub +
                ", hasRestaurant=" + hasRestaurant +
                '}';
    }
}
