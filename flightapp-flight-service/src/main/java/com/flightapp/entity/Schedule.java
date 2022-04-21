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
	
	Date startTime;
	
	public Schedule(long airlineId, String source, String destination, Date startTime) {
		this.airlineId = airlineId;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
	}
}
