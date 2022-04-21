package com.flightapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface AirlineService {

	// ResponseEntity<Airline> registerAirline(Airline airline);
	
	ResponseEntity<String> registerAirline(HttpEntity<String> data);
	

}