package com.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
