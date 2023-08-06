package com.h2Test.demo.repository;

import com.h2Test.demo.entity.Event;
import com.h2Test.demo.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

    public Registration findByRegistrationId(String name);
}
