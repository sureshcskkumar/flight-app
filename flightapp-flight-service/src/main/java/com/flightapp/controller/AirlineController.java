package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Airline;
import com.flightapp.service.AirlineService;

@RestController
@RequestMapping("/flight")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;

	@PostMapping("/register")
	public ResponseEntity<Airline> registerAirline(@RequestBody Airline airline) {
		return airlineService.registerAirline(airline);
	}
}
