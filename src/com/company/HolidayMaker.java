package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
    private String customerEmail;
    private String option;

    public void holidayProgramInit (){
        dBComms.connectToDb();
        dBComms.getUsersFromDb();
        dBComms.printUserResultSetFromDb();
        menu.printMenu();
        userMenuPick();
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
        dBComms.addUserToDb(customerName,noOfPeople,customerEmail);
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
        }
    }
    public void roomSearch(){
        dBComms.getRoomsFromDb();
    }

    public void cancelBooking(){

    }
}

