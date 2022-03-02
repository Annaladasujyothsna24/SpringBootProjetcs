package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

@Repository
// By default this will get connection object automatically without any manual code

/*
 *
 * For every table ==> CRUD Operation
 *
 *  C ==> CREATE (INSERT), R ==> READ (SELECT) U ==> UPDATE (UPDATE) D ==> DELETE (DELETE)
 *
 *  Framework is creating a resposity i.e, CrudRepository with some default methods for above CRUD Operations
 *
 *  CRUDRepository expects two parameter
 *  1) EntityName 2) DataType of PrimaryKey of the Entity
 */
public interface TicketDao extends CrudRepository<Ticket, Integer>{

	//This repository will internally have default methods for CRUD Operations


	//Create ==> save

	//Update ==> save

	//delete ==> deleteById

	//GetAll ==> findAll

	//GetSingle ==>findById


	//Collection Framework ==> If i am getting multiple tickets
	//Retrieveing mutiple tickets ==> findAllById
	//saveAll

	//findAllById


	//Writing Derived Method for getting the data using passengerName

	public Ticket findByPassengerName(String passengerName);  //Abstract Method
	//Framework will implement
	//select * from tbl_ticket where passenger_name=passengerName


}
