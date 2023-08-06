package com.h2Test.demo.controller;

import com.h2Test.demo.entity.Event;
import com.h2Test.demo.entity.Registration;
import com.h2Test.demo.repository.EventRepository;
import com.h2Test.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    @PostMapping("/event/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){

        eventRepository.save(event);

        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getByEventId(@PathVariable String id){

        Event event = eventRepository.findByEventId(id);

        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    @GetMapping("/event/location/{location}")
    public ResponseEntity<List<Event>> getByEventLocation(@PathVariable String location){

        List<Event> event = eventRepository.findByLocation(location);

        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    @GetMapping("/event/{id}/registrations")
    public ResponseEntity<Set<Registration>> getRegistrationForEvent(@PathVariable String id){
        Set<Registration> registrationForEvent = eventService.getRegistrationForEvent(id);
        return new ResponseEntity<>(registrationForEvent, HttpStatus.OK);
    }


}
