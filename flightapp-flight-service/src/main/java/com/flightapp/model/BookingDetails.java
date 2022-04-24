package com.flightapp.model;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
	
	private List<Passenger> passengers;
	
	private List<Integer> seatNumbers;
	
	@Enumerated(EnumType.STRING)
	private MealOption mealOption;
}
