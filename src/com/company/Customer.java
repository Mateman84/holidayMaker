package com.company;

public class Customer {

    private String customerName;
    private String customerEmail;
    private int noOfPeople;

    public Customer(String customerName, int noOfPeople, String customerEmail) {
        this.customerName = customerName;
        this.noOfPeople = noOfPeople;
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", noOfPeople=" + noOfPeople +
                '}';
    }
}
