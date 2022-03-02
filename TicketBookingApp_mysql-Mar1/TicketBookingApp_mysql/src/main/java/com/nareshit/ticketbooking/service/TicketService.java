package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

import org.springframework.stereotype.Service;

@Service
//Mainly used for achieving Transaction Mgmt,
//any other external tools connectivity like rabmitmq,kafka..etc
public class TicketService {

	// IN this layer we are going to write create, update ,delete , get ticket
	// methods

	@Autowired
	private TicketDao ticketDao; // What ever the memory reference of this class it will get that refernce

	// Create Ticket Method
	public Ticket createTicket(Ticket ticket) {

		// save method is going to trigger insert query to the database
		// save Method is also going to trigger update query to the database
		// if ticket is not having value to ticketId , ticketId value is not in database
		// ==> Insert
		// If ticketid is there in the database ==> It will trigger update statement to
		// the database.
		return ticketDao.save(ticket);

	}

	/// Retrive all Tickets
	public Iterable<Ticket> getTickets() {

		// findAll ==> It will trigger query ==> select * from tbl_ticket
		// Entire Resultset will converted into any CollectionDataType<Entity>
		return ticketDao.findAll();

	}

	// Retrieve a particual Ticket
	/*
	 *
	 * Ticket ticketObj=getTicket(2000); if(ticketObj!=null){ if
	 * ticketObj.getPassengerName()...NullPointer Exception
	 *
	 * Optional Means ==> This may return result else null If Optional is there
	 * ticketObj.getPassengerName() ==null value it returns }
	 */

	public Ticket getTicket(Integer ticketId) {
		// findById ==> select * from tbl_ticket where ticket_id=ticketId
		return ticketDao.findById(ticketId).orElse(new Ticket());
	}

	// Update Ticket

	public Ticket updateTicket(Integer ticketId, String newEmail) {

		Ticket dbTicketObj = getTicket(ticketId);
		// dbTicketObj will have valid TicketId

		dbTicketObj.setEmail(newEmail);

		return ticketDao.save(dbTicketObj);
		// Here Save method will trigger Update Query
		// update tbl_ticket set email=newEmail where ticket_id=ticketId

	}

	// Delete Ticket

	public void deleteTicket(Integer ticketId) {
		// deleteById ==> delete tbl_ticket where ticket_id=ticketId
		ticketDao.deleteById(ticketId);
	}


	public Ticket findByPassengerName(String passengerName) {
		return ticketDao.findByPassengerName(passengerName);
	}

}
