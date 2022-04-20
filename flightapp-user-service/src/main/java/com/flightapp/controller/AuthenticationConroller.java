package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.AuthenticationRequest;
import com.flightapp.model.UserDTO;
import com.flightapp.service.UserService;



@RestController
public class AuthenticationConroller {


	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		return userService.createAuthenticationToken(authenticationRequest);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return userService.save(user);
	}
	
}
