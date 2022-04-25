package com.flightapp.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flightapp.model.AgeGroup;
import com.flightapp.model.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String airlineName;

	private String name;
	
	private AgeGroup ageGroup;
	
	private Gender gender;

	private String source;

	private String destination;

	private LocalDate flightDate;

	private LocalTime flightTime;
	
	private UUID pnr;

}
