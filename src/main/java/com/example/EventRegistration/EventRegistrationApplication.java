package com.example.EventRegistration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		// Import scanner and take ClassPathXmlApplicationContext.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Graduation Ceremony Registration Application");
		// Take the college event bean from the application context.
		CollegeEvent event = (CollegeEvent) context.getBean("event");
		// Print the event details.
		event.printEventDetails();

		while (true) {
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			int input = scanner.nextInt();
			if (input == 1) {
				scanner.nextLine(); // Consume newline character

				System.out.println("Please enter your name:");
				String name = scanner.nextLine();

				System.out.println("Please enter your department:");
				String department = scanner.nextLine();

				System.out.println("In which year did you pass out?");
				int year = scanner.nextInt();

				// Create a new attendee
				StudentAttendee attendee = (StudentAttendee) context.getBean("student");


				// Register the attendee for the event
				event.registerStudent(attendee);

				// Print the registration confirmation
				System.out.println("Hi " + name + ", your registration for the Graduation Ceremony is successful.");

			} else if (input == 2) {
				break;
			} else {
				System.out.println("Invalid Choice");
				return;
			}
		}

		// Get the number of attendees and print along with the statement below
		int attendeeCount = event.getAttendeeCount();
		System.out.println("No. of attendees registered are: " + attendeeCount);
		System.out.println("The list of attendees are:");

		// Print all the attendee names with their reference ids
		for (Attendee attendee : event.getAllAttendees()) {
			System.out.println(attendee.getAttendeeName() + " Reference id: @" + Integer.toHexString(attendee.hashCode()));
		}

		// Close the context
		context.close();
	}
}
