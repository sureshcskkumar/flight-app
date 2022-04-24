package com.flightapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.flightapp.model.Airline;

public interface AirlineService {

	// ResponseEntity<Airline> registerAirline(Airline airline);
	
	ResponseEntity<Airline> registerAirline(HttpEntity<Airline> data);
	

}