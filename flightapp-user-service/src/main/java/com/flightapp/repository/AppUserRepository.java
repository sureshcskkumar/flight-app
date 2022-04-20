package com.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByEmail(String email);

}
