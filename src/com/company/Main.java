package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        HolidayMaker holiday = new HolidayMaker();
	    /*
        LocalDate myObj = LocalDate.of(2015, 02, 20);; // Create a date object
        System.out.println(myObj);
*/
	    holiday.holidayProgramInit();
	    //holiday.addUserToDb("Mattias", 5, "Matte@genericEmail.com");
        /*holiday.getUsersFromDb();
	    holiday.printUserResultSetFromDb();
		menu.printMenu();
		menu.userPickMenuOption();*/
    }
}
