package com.company;

import java.sql.*;
import java.time.LocalDate;

public class Communicator {

    Connection conn = null;
    ResultSet resultSet;
    PreparedStatement statement;

    void connectToDb(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/holidaymaker?user=root&password=mysql&serverTimezone=UTC");
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    int addUserToDb(String name, int noOfPeople, String email){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO customers (name, noofpeople, email) VALUES ('" + name + "', " + noOfPeople + ", '" + email + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                //System.out.println(generatedKeys.getLong("GENERATED_KEY"));
                return generatedKeys.getInt("GENERATED_KEY");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    void addBookingToDb(LocalDate bookingStart, LocalDate bookingEnd, int customerId, int roomId){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO bookings (bookingstart, bookingend, customer_id, room_id) VALUES ('" + bookingStart + "', '" + bookingEnd + "', " + customerId + ", " + roomId + ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getLong("GENERATED_KEY"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void getUsersFromDb(){
        try {
            statement = conn.prepareStatement("SELECT * FROM customers");
            resultSet = statement.executeQuery();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void getRoomsFromDb(){
        try {
            statement = conn.prepareStatement("SELECT * FROM rooms");
            resultSet = statement.executeQuery();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void getBookingsFromDb(){
        try{
            statement = conn.prepareStatement("SELECT * FROM bookings");
            resultSet = statement.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void getRoomsAvailableBetween(LocalDate desiredStartDate, LocalDate desiredEndDate){
        try{
            statement = conn.prepareStatement("SELECT id, roomname, hotels_id, roomsizes_id\n" +
                    "FROM rooms\n" +
                    "WHERE rooms.id NOT IN (SELECT bookings.room_id\n" +
                    "FROM bookings\n" +
                    "WHERE bookings.bookingstart BETWEEN '" + desiredStartDate + "' AND '" + desiredEndDate + "' OR bookings.bookingend BETWEEN '" + desiredStartDate + "' AND '" + desiredEndDate + "')");
            resultSet = statement.executeQuery();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void printRoomResultSetFromDb(){
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("roomname");
                int hotel = resultSet.getInt("hotels_id");
                int roomSize = resultSet.getInt("roomsizes_id");
                Date availableFrom = resultSet.getDate("availablefrom");
                Date availableUntil = resultSet.getDate("availableuntil");
                System.out.println("RoomID: " + id + ". Roomname: " + name + ". HotelID: " + hotel + ". RoomSizeID: " + roomSize + ". AvailableFrom: " + availableFrom + ". AvailableUntil: " + availableUntil);
            }
        } catch (Exception ex){ ex.printStackTrace(); }
    }

    void printAvailableRoomsSetFromDb(){
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("roomname");
                int hotel = resultSet.getInt("hotels_id");
                int roomSize = resultSet.getInt("roomsizes_id");
                System.out.println("BookingID: " + id + ". Roomname: " + name + ". Hotel: " + hotel + ". Roomsize: " + roomSize + ".");
            }
        } catch (Exception ex){ ex.printStackTrace(); }
    }


    void printUserResultSetFromDb(){
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int numPeople = resultSet.getInt("noofpeople");
                String email = resultSet.getString("email");
                System.out.println(id + " " + name + " " + numPeople + " " + email);
            }
        } catch (Exception ex){ ex.printStackTrace(); }
    }

    void  getRoomsWithCriterias (){
        
    }
}
