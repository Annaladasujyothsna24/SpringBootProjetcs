package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

//As part of JPA Implementation Every Java Class should have corresponding table

@Entity // JPA will create a table to the database with table name as Ticket
@Table(name = "tbl_ticket") //This will create a table with tbl_ticket Name
@DynamicUpdate
public class Ticket {


	@Id ///Primary Key Annotation ==> ticketId will be primarykey
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;


	//Every table should have primary key

	//By default every property of the java class is database column
	@Column(name = "passenger_name")
	private String passengerName;


	@Column(name = "travel_date")
	private Date travelDate;


	@Column(name = "source_station")
	private String sourceStation;

	@Column(name = "destination_station")
	private String destinationStation;


	private String email;


	//Ticket ticket = new Ticket("sdfasd,"sdfasdfasd","sdfdsafasd","sadfasdfsad");
	//Ticket ticket = new Ticket();
	//ticket.setPasssengerName("Sdfasdf");


	public Ticket(String passengerName,  String sourceStation, String destinationStation,
			String email) {
		super();
		this.passengerName = passengerName;
		this.travelDate = new Date();
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.email = email;
	}

	public Ticket() {}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", travelDate=" + travelDate
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", email=" + email
				+ "]";
	}





}
