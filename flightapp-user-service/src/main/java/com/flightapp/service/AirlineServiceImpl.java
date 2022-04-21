package com.flightapp.service;

import static com.flightapp.config.ApplicationConstants.AIRLINE_REGISTER;
import static com.flightapp.config.ApplicationConstants.FLIGHTAPPURL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
    private RestTemplate template;
	
	@Override
	public ResponseEntity<String> registerAirline(HttpEntity<String> data) {
		
		String url = FLIGHTAPPURL + AIRLINE_REGISTER;
		
		HttpMethod method = HttpMethod.POST;
        ResponseEntity<String> response = template.exchange(url, method, data, String.class);

        return response;

	}

}
