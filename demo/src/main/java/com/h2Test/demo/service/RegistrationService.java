package com.h2Test.demo.service;

import com.h2Test.demo.entity.Event;
import com.h2Test.demo.entity.Registration;
import com.h2Test.demo.repository.EventRepository;
import com.h2Test.demo.repository.RegistrationRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

// retrieving students/registration by courseId/eventId:
@Service
public class RegistrationService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepo registrationRepo;

    public List<Registration> getRegistrationByEventId(Integer eventId) {
        Optional<Event> eventOp = eventRepository.findById(eventId);

        if (eventOp.isPresent()) {
            Event event = eventOp.get();
            System.out.println("***********************event: "+event);
            return new ArrayList<>(event.getRegistrationSet());
        } else {
            System.out.println("***********************event not found**************");
            throw new EntityNotFoundException("Course not found with id: " + eventId);
        }
    }

    public Registration assignEventToRegistration(String registrationId, String eventId) {

        Set<Event> eventSet = null;
        Registration registration = registrationRepo.findByRegistrationId(registrationId);
        Event event = eventRepository.findByEventId(eventId);
        eventSet =  registration.getEventSet();
        eventSet.add(event);
        registration.setEventSet(eventSet);
        return registrationRepo.save(registration);
    }
}
