package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value = "/tickets")
//http://localhost:8080/tickets==> TicketController ticketObj=ioc.getTicketController();
public class TicketController {

	/*
	 * JAX RS ==> Java API for XML Rest Services===> JSON
	 *
	 * WEB SERVICE ==> Heterogenious Communication SOAP SERVICE AND REST SERVICE
	 *
	 * SOAP SERVICE ==> SOAP PROTOCOL ==> TIGHTLY COUPLED ==> WE CANT EASILY CALL
	 * REST SERVICE ==> HTTP PROTOCOL ==> LOOSELY COUPLED ==> EVERY ONE CAN EASILY
	 * USE HTTP
	 *
	 * @Controller ==> our input request will come from JSP page only..Both Frontend
	 * and Middlware should be in same langauge
	 *
	 * @RestController ==> our input request can came from any where from outside
	 * world like Angular,React,GO,PHP, Dotnet,C++ etc..
	 *
	 *
	 * VERBS ==> GET ==> TO GET THE DATA ==> POST ==> TO CREATE THE DATA ==> PUT ==>
	 * TO UPDATE THE DATA ==> DELETE ==> TO ELETE THE DATA
	 *
	 *
	 * REQUEST ==> HTTPREQUEST AND RESPONSE WILL BE RETURNED IN THE FROM OF
	 * HTTPRESPONSE
	 *
	 * JSON IS THE COMMUNICATION OBJECT BETWEEN CLIENT AND SERVER
	 *
	 * BY DEFAULT JAVA TO JSON AND JSON TO JAVA CONVERSIONS TAKEN CARE BY FRAMEWORK.
	 *
	 * IT USES JACKSON LIBRARY FOR THE CONVERSION
	 *
	 * @RequestMapping at Method level ...@Get/@Post/@Put,@Delete
	 *
	 * @GetMapping ==> @Get + @RequestMapping
	 *
	 * @PostMapping ==> @Post+ @RequestMapping ....
	 *
	 *
	 *
	 *
	 */

	// Getting All Tickets

	@Autowired
	private TicketService ticketService; // TicketService ticketService=ioc.getTicketService();

	// Getting All Tickets
	@GetMapping(value = "/all") // http://localhost:8080/tickets/all
	// all ==> ticketObj.getAllTickets();
	// Output Iterable<Ticket> will be converted JSON and given to FE
	public Iterable<Ticket> getAllTickets() {
		return ticketService.getTickets();

	}

	/*
	// Get a Ticket
	@GetMapping(value = "/{ticketId}")
	// http://localhost:8080/tickets/1 ==> 1st Ticket
	// http://localhost:8080/tickets/2 ==> 2nd Ticket
	// Towrite dynamic variable in requestmapping we need to use { }
	// @PathVariable ==> Reading the variable from URI / URL
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}

*/

	// Get a Ticket by PassengerName
		@GetMapping(value = "/{passengerName}")
		// http://localhost:8080/tickets/Ramu ==> 1st Ticket
		// http://localhost:8080/tickets/Lakshman ==> 2nd Ticket
		// Towrite dynamic variable in requestmapping we need to use { }
		// @PathVariable ==> Reading the variable from URI / URL
		public Ticket getTicketByPassengerName(@PathVariable("passengerName") String  passengerName) {
			return ticketService.findByPassengerName(passengerName);
		}

	// Update Ticket

	@PutMapping(value = "/{ticketId}/{newEmail}")
	// http://localhost:8080/tickets/1/a@b.com ==>1st Ticket new Email ===> a@b.com
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
								@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}

	// Create Ticket
	@PostMapping(value="/create") //http://localhost:8080/tickets/create
	//@PostMapping ==> @Post + @RequestMapping
	//Body Section in the request ==> All my input data should be part of Body
	public Ticket createTicket( @RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);

	}


	//Delete Ticket
	@DeleteMapping(value = "/{ticketId}")
  public void deleteTicket(@PathVariable("ticketId")  Integer ticketId) {
	  ticketService.deleteTicket(ticketId);
  }
}
