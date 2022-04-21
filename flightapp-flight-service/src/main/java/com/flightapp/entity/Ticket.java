package com.flightapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long airlineId;
	
	private String name;


	private String ageCategory;
	
	private String source;
	
	private String destination;
	
	Date flightTime;
	
	public Ticket(long airlineId, String name, String ageCategory, String source, String destination, Date flightTime) {
		this.airlineId = airlineId;
		this.name = name;
		this.ageCategory = ageCategory;
		this.source = source;
		this.destination = destination;
		this.flightTime = flightTime;
	}
	
}
