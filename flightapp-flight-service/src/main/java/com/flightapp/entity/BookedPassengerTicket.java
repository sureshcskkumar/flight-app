package com.flightapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booked_passenger_tickets")
public class BookedPassengerTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;
	
	private long ticketId;
	
	private String PassengerName;
	
	private LocalDateTime timeOfBooking;

	public BookedPassengerTicket(long ticketId, String passengerName, LocalDateTime timeOfBooking) {
		this.ticketId = ticketId;
		PassengerName = passengerName;
		this.timeOfBooking = timeOfBooking;
	}

}
