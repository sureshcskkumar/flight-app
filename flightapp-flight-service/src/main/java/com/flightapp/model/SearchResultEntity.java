package com.flightapp.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flightapp.entity.Schedule;

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
	
	private double ticketCost;

	public SearchResultEntity(String airlineName, Schedule schedule) {
		this.airlineName = airlineName;
		this.startTime = schedule.getStartTime();
		this.endTime = schedule.getEndTime();
		this.ticketCost = schedule.getTicketCost();
	}

	
}
