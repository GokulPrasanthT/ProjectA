package com.chainsys.projectA.beans;

// Calendar Factory is also called as initiating bean beacause methods in this bean instantiates object  for other beans
public class CalendarFactory {
	// The Factory method is not static here
	public Calendar createCalendar() {
		// The Calendar Constructor is defult Acess Modifier so, can be called here
		// The claendar Class and the Calendar Factory Calss are both in the same
		// package.
		return new Calendar();
	}

	public Appointments createAppointments() {

		return new Appointments();
	}
}
