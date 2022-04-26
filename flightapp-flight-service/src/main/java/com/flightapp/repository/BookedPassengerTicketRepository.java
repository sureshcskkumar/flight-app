package com.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.BookedPassengerTicket;

public interface BookedPassengerTicketRepository extends JpaRepository<BookedPassengerTicket, Long> {

}
