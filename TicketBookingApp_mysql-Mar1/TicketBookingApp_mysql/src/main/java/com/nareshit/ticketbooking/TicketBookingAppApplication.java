package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@SpringBootApplication

//CommandLineRunner is an interface which will have run == Which can called only once i.e. during startup

public class TicketBookingAppApplication implements CommandLineRunner {

	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		Ticket ticket=new Ticket();
		ticket.setPassengerName("RAMU");
		ticket.setSourceStation("HYDERABAD");
		ticket.setDestinationStation("GOA");
		ticket.setTravelDate(new Date());
		ticket.setEmail("ramu@gmail.com");*/

		//ticketService.createTicket(ticket);

	}

}
