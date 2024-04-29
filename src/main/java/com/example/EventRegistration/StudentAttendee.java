package com.example.EventRegistration;

import java.io.Serializable;

public class StudentAttendee implements Attendee{

    /*
    1. Create the following attributes:
        a. name (String)
        b. batch (int)
        c. department (String)
    2. Make this class an implementation of Attendee interface and override the interface methods.
    */
    String name;
    int batch;
    String department;


    @Override
    public void setAttendeeDetails(String name, String department, int batch) {
        this.name = name;
        this.department = department;
        this.batch = batch;
    }

    @Override
    public void printRegistrationConfirmation() {
      System.out.print("Hi"+ " "+name+"," + " "+"your registration for Graduation Ceremony is Successful");
    }

    @Override
    public String getAttendeeName() {
        return this.name;
    }
}
