package com.h2Test.demo.service;

import com.h2Test.demo.entity.Registration;
import com.h2Test.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Set<Registration> getRegistrationForEvent(String eventId){

        return eventRepository.findByEventId(eventId).getRegistrationSet();
    }



}
