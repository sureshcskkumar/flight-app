package com.flightapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long airlineId;
	
	private String source;
	
	private String destination;
	
	@Temporal(TemporalType.TIME)
	Date departureTime;
	
	public Schedule(long airlineId, String source, String destination, Date departureTime) {
		this.airlineId = airlineId;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
	}
}
