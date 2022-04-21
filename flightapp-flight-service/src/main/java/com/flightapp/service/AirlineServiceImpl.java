package com.flightapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Schedule;
import com.flightapp.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	
	@Override
	public ResponseEntity<Airline> registerAirline(Airline airline) {
		
		Objects.requireNonNull(airline);
		List<Airline> airlineList = airlineRepository.findByName(airline.getName());
		if (airlineList != null && airlineList.size() > 0) {
			return new ResponseEntity("Airline with requested name already exists!", HttpStatus.BAD_REQUEST);
		}
		
		airline = airlineRepository.save(airline);
		return ResponseEntity.ok(airline);
	}


	@Override
	public ResponseEntity<Schedule> addSchedule(Schedule schedule) {

		return null;		
	}
	
}
