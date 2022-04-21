package com.flightapp.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {

	private long airlineId;
	private String source;
	private String destination;
	Date startTime;
	List<Passenger> passengers;
	
}
