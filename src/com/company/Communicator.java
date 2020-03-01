package com.company;

import java.sql.*;

public class Communicator {

    Connection conn = null;
    ResultSet resultSet;
    PreparedStatement statement;

    void connectToDb(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/holidaymaker?user=root&password=mysql&serverTimezone=UTC");
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void addUserToDb(String name, int noOfPeople, String email){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO customers (name, noofpeople, email) VALUES ('" + name + "', " + noOfPeople + ", '" + email + "')", Statement.RETURN_GENERATED_KEYS);

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

    void printUserResultSetFromDb(){
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String numPeople = resultSet.getString("noofpeople");
                String email = resultSet.getString("email");
                int noOfPeople = Integer.parseInt(numPeople);
                System.out.println(id + " " + name + " " + noOfPeople + " " + email);
            }
        } catch (Exception ex){ ex.printStackTrace(); }
    }
}
