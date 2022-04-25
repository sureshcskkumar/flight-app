package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.ScheduleRepository;

@Service
public class SearchServiceImpl implements SearchService {


	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	
	
}
