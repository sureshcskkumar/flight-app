package com.flightapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightapp.model.AppUser;
import com.flightapp.repository.AppUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
		String userEmail = username;
		AppUser user = userRepository.findByEmail(userEmail);
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getEmail(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the email " + userEmail);	
	}

}
