package com.flightapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.SearchResult;
import com.flightapp.service.SearchService;

@RestController
@RequestMapping("/flight")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search")
	public ResponseEntity<SearchResult> search(
			@RequestParam("fromPlace") String fromPlace,
			@RequestParam("toPlace") String toPlace,
			@RequestParam("flightDate") LocalDate flightDate,
			@RequestParam(value = "flightDate", required = false) LocalDate returnDate
			){
		return searchService.search(fromPlace, toPlace, flightDate, returnDate);
	}
	
}
