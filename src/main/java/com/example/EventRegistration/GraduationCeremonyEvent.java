package com.example.EventRegistration;

import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent {

    /*
     * 1. Create the following attributes: a. name (initialize it as "Graduation
     * Ceremony". b. address (String) c. time (String) d. date (String) e. count
     * (int) (initially 0) f. eventAttendees (List of Attendee) NOTE: Initialize
     * the address, time and date attributes with some values.
     */
    String name = "Graduation Ceremony";
    String address="Auditorium";
    String time="10AM";
    String date="12 nov 2023";
    int count = 0;
    List<Attendee> eventAttendees = new ArrayList<Attendee>();

    public GraduationCeremonyEvent(String address, String time, String date) {
        this.address = address;
        this.time = time;
        this.date = date;
    }

    public GraduationCeremonyEvent() {

    }

    @Override
    public void setAttendee(Attendee attendee) {
        eventAttendees.add(attendee);
    }

    @Override
    public void registerStudent(Attendee user) {
        eventAttendees.add(user);
        count++;
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("The Graduation Ceremony details are as follows:");
        System.out.println("Venue: " + address);
        System.out.println("Time: " + time);
        System.out.println("Date: " + date);
    }

    @Override
    public int getAttendeeCount() {
        return count;
    }
}
