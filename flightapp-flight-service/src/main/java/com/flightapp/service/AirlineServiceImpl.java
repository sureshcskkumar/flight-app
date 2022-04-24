package com.flightapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Schedule;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.ScheduleRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
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

		Objects.requireNonNull(schedule);
		Optional<Airline> airlineOptional = airlineRepository.findById(schedule.getAirlineId());
		if (!airlineOptional.isPresent()) {
			return new ResponseEntity("Airline does not exist! Schedule can be added only for existing airlines", HttpStatus.BAD_REQUEST);
		}
		
		List<Schedule> scheduleList = scheduleRepository.findByAirlineIdAndDateTime(
				schedule.getAirlineId(),
				schedule.getFlightDate(),
				schedule.getStartTime());
		if (scheduleList != null && scheduleList.size()>0) {
			return new ResponseEntity("Schedule already exists for the airline at the requested dtae and time! Please choose a different date or time", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(scheduleRepository.save(schedule), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<Airline>> findAll() {
		return new ResponseEntity<>(airlineRepository.findAll(), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<Airline>> findByName(String airlineName) {
		return new ResponseEntity<>(airlineRepository.findByName(airlineName), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Airline> updateAirline(Airline airline) {
		Objects.requireNonNull(airline);
		Optional<Airline> airlineOptional = airlineRepository.findById(airline.getId());
		if (airlineOptional.isPresent()) {
			return new ResponseEntity<>(airlineRepository.save(airline), HttpStatus.OK);
		}
		return new ResponseEntity("The airline that you are trying to update does not exist!", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> deleteAirline(long airlineId) {
		
		Optional<Airline> airlineOptional = airlineRepository.findById(airlineId);
		if (airlineOptional.isPresent()) {
			airlineRepository.deleteById(airlineId);
			return new ResponseEntity<>("Airline deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Airline does not exist", HttpStatus.BAD_REQUEST);
		
	}


	@Override
	public ResponseEntity<Airline> findById(long airlineId) {
		Optional<Airline> airlineOptional = airlineRepository.findById(airlineId);
		if (airlineOptional.isPresent()) {
			return new ResponseEntity<>(airlineOptional.get(), HttpStatus.OK);
		}
		return new ResponseEntity("Airline does not exist", HttpStatus.BAD_REQUEST);
	}
	
}
