package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.entities.Event;
import com.thefivebytes.mmc.entities.SessionType;


import java.util.List;
import java.util.Optional;

public interface IEventService {

    List<Event> findAll();

    Optional<Event> findById(Long id);
    Event save(Event event);

    Event update(Event event);

    int delete(Long id);
}
