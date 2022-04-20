package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightapp.config.JwtUtil;
import com.flightapp.model.AppUser;
import com.flightapp.model.AuthenticationRequest;
import com.flightapp.model.AuthenticationResponse;
import com.flightapp.model.UserDTO;
import com.flightapp.repository.AppUserRepository;

@Service
public class UserService {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ResponseEntity<AppUser> save(UserDTO user) {
		AppUser newUser = new AppUser();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		return ResponseEntity.ok(userRepository.save(newUser));
	}
	
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		String token = jwtUtil.generateToken(userdetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
}
