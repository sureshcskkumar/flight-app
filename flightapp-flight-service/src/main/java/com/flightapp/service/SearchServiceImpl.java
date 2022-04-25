package com.flightapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Schedule;
import com.flightapp.model.SearchResult;
import com.flightapp.model.SearchResultEntity;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.ScheduleRepository;

@Service
public class SearchServiceImpl implements SearchService {


	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public ResponseEntity<SearchResult> search(String fromPlace, String toPlace, LocalDate flightDate, LocalDate returnDate) {

		List<SearchResultEntity> flightSearchEntities = searchResult(fromPlace, toPlace, flightDate);
		
		List<SearchResultEntity> returnSearchEntities = null;
		if (returnDate!=null) {
			returnSearchEntities = searchResult(toPlace, fromPlace, flightDate);
		}
		
		return new ResponseEntity<>(new SearchResult(fromPlace, toPlace, flightDate, returnDate, flightSearchEntities, returnSearchEntities), HttpStatus.OK);
		
	}
	
	private List<SearchResultEntity> searchResult(String fromPlace, String toPlace, LocalDate flightDate) {
		List<Schedule> flightSchedules = scheduleRepository.searchFlights(fromPlace, toPlace, flightDate);

		List<SearchResultEntity> searchResulList = new ArrayList<>();
		if (flightSchedules == null || flightSchedules.size() <= 0) {
			for (Schedule schedule : flightSchedules) {
				Optional<Airline> airlineOptional = airlineRepository.findById(schedule.getAirlineId());
				if (airlineOptional.isPresent()) {
					searchResulList.add(new SearchResultEntity(airlineOptional.get().getName(), schedule));
				}
			}
		}
		return searchResulList;
	}
	
}
