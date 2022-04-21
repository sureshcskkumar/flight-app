package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	
	@Override
	public ResponseEntity<Airline> registerAirline(Airline airline) {
		airline = airlineRepository.save(airline);
		return ResponseEntity.ok(airline);
	}
	
}
