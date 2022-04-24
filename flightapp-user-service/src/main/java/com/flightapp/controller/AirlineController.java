package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.Airline;
import com.flightapp.service.AirlineService;

@RestController
@RequestMapping("/api/v1.0")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;

	@PostMapping("/flight/register")
	public ResponseEntity<String> registerAirline(@RequestBody Airline airline) {
		return airlineService.registerAirline(null);
	}
	
	
}
