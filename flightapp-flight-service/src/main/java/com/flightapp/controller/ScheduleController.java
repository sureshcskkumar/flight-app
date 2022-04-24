package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.service.ScheduleService;

@RestController
@RequestMapping("/flight")
public class ScheduleController {

	@Autowired
	private ScheduleService ScheduleService;
	
}
