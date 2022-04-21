package com.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
