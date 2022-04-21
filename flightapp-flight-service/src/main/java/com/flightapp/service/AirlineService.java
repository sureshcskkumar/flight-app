package com.flightapp.service;

import org.springframework.http.ResponseEntity;

import com.flightapp.entity.Airline;

public interface AirlineService {

	ResponseEntity<Airline> registerAirline(Airline airline);

}