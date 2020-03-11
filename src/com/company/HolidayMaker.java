package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HolidayMaker {

    private Scanner myInput = new Scanner(System.in);
    private Menu menu = new Menu();
    private Communicator dBComms = new Communicator();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private Customer customer;
    private String customerName;
    private int noOfPeople;
    private int customerId;
    private int roomId;
    private String customerEmail;
    private String option;
    private String answer;
    private String startDate;
    private String endDate;


    public void holidayProgramInit (){
        dBComms.connectToDb();
        //dBComms.getUsersFromDb();
        //dBComms.getRoomsFromDb();
        //dBComms.getBookingsFromDb();
        //dBComms.printUserResultSetFromDb();
        //dBComms.printRoomResultSetFromDb();
        //dBComms.printBookingsSetFromDb();
        findfreeRoomsBetweenDates(LocalDate.parse("2020-06-01"), LocalDate.parse("2020-06-30"));

        /*menu.printMainMenu();
        userMenuPick();*/
    }

    public void addCustomer(){
        System.out.println("Enter name of customer");
        customerName = myInput.nextLine();
        System.out.println("Enter number of people");
        noOfPeople = myInput.nextInt();
        myInput.nextLine();
        System.out.println("Enter email of customer");
        customerEmail = myInput.nextLine();
        System.out.println("You've entered the following: 'name:' " + customerName + ", 'number of people:' " + noOfPeople  + ", 'customer email:' " + customerEmail);
        customerId = dBComms.addUserToDb(customerName,noOfPeople,customerEmail);
        addBookingQuestion();
        //System.out.println(customerId);
        //return customerId;
    }
    void userMenuPick(){
        option = myInput.nextLine();
        switch(option){
            case "1":
                System.out.println("You choose 1");
                addCustomer();
                break;
            case "2":
                System.out.println("You choose 2");
                roomSearch();
                break;
            case "3":
                System.out.println("You choose 3");
                cancelBooking();
                break;
            case "4":
                System.out.println("You choose 4");
                addBookingForCustomer();
                break;
        }
    }
    public void roomSearch(){
        dBComms.getRoomsFromDb();
    }

    public void cancelBooking(){

    }

    public void addBookingQuestion(){
        System.out.println("Would you like to add a booking for the customer? Y/N");
        answer = myInput.nextLine();
        if(answer.equalsIgnoreCase("y")){
            addBookingForCustomer();
        } else {
            System.out.println("Thank you for registering!");
            System.exit(1);
        }
    }

    public void addBookingForCustomer(){
        System.out.println("Enter start date of your booking with the following format: YYYY-MM-DD");
        startDate = myInput.nextLine();
        System.out.println("Enter end date for your booking with the following format: YYYY-MM-DD");
        endDate = myInput.nextLine();
        myInput.nextLine();
        System.out.println("Enter id of customer");
        customerId = myInput.nextInt();
        System.out.println("Enter id of room");
        roomId = myInput.nextInt();
        System.out.println("You've entered the following: 'Startdate:' " + startDate + ", 'Enddate:' " + endDate  + ", 'customer id:' " + customerId + ", 'room id:' " + roomId);
        dBComms.addBookingToDb(LocalDate.parse(startDate), LocalDate.parse(endDate), customerId, roomId);
    }

    public void findfreeRoomsBetweenDates(LocalDate desiredBookingStart, LocalDate desiredBookingEnd){
        dBComms.getRoomsAvailableBetween(desiredBookingStart, desiredBookingEnd);
        dBComms.printAvailableRoomsSetFromDb();
    }
}

