package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.flightapp.entity.BookedPassengerTicket;
import com.flightapp.repository.BookedPassengerTicketRepository;

@Service
public class KafkaConsumerListener {

    private static final String TOPIC = "kafka_topic";
    
    @Autowired
    private BookedPassengerTicketRepository bookedPassengerTicketRepository;

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(BookedPassengerTicket bookedPassengerTicket) {
    	bookedPassengerTicketRepository.save(bookedPassengerTicket);
        System.out.println("Consumed JSON Message: " + bookedPassengerTicket);
    }
    
}