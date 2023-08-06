package com.h2Test.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Registration {

    @Id
    private String registrationId;

    private String userName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_like",
            joinColumns = @JoinColumn(name = "registrationId"),
            inverseJoinColumns = @JoinColumn(name = "eventId"))
    private Set<Event> eventSet = new HashSet<>();
}
