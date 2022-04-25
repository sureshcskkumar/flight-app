package com.flightapp.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultEntity {

	private String airlineName;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private int ticketCost;
	
	
}
