package com.h2Test.demo.controller;

import com.h2Test.demo.entity.Registration;
import com.h2Test.demo.repository.RegistrationRepo;
import com.h2Test.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    public RegistrationRepo registrationRepo;

    @Autowired
    public RegistrationService registrationService;

    @PostMapping("/registration/create")
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration){

        registrationRepo.save(registration);

        return new ResponseEntity<>(registration, HttpStatus.OK);

    }

    @GetMapping("event/{eventId}/registration")
    public List<Registration> getRegistrationByEventId(@PathVariable Integer eventId) {
        System.out.println("Hello");
        return registrationService.getRegistrationByEventId(eventId);
    }

    @PutMapping("/map/{registrationId}/event/{eventId}")
    public Registration assignEventToRegisteredUser(
            @PathVariable String registrationId,
            @PathVariable String eventId
    ){
        return registrationService.assignEventToRegistration(registrationId, eventId);
    }



}
