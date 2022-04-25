package com.flightapp.service;

import org.springframework.http.ResponseEntity;

import com.flightapp.entity.Schedule;

public interface ScheduleService {

	ResponseEntity<Schedule> addSchedule(Schedule schedule);

}
