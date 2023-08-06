package com.h2Test.demo.repository;

import com.h2Test.demo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    public Event findByEventId(String name);

    public List<Event> findByLocation(String location);

}
