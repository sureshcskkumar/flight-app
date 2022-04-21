package com.flightapp.service;

import org.springframework.http.ResponseEntity;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Schedule;

public interface AirlineService {

	ResponseEntity<Airline> registerAirline(Airline airline);

	ResponseEntity<Schedule> addSchedule(Schedule schedule);

}