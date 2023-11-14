package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.converters.EventConverter;
import com.thefivebytes.mmc.dto.EventDto;
import com.thefivebytes.mmc.entities.Event;
import com.thefivebytes.mmc.services.facade.IEventService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {


    private IEventService eventService;

    public EventController(IEventService eventService ) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public List<EventDto> findAll() {
        return EventConverter.toDto(eventService.findAll());
    }

    @GetMapping("/id/{id}")
    public EventDto findById(@PathVariable Long id) {
        return EventConverter.toDto(eventService.findById(id).get());
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventDto save(@RequestBody EventDto eventDto) {
        Event entity = EventConverter.toEntity(eventDto);
        entity = eventService.save(entity);
        return EventConverter.toDto(entity);
    }

    @PutMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventDto update(@RequestBody EventDto eventDto) {
        Event entity = EventConverter.toEntity(eventDto);
        entity = eventService.update(entity);
        return EventConverter.toDto(entity);

    }

    @DeleteMapping("/id/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public int delete(@PathVariable Long id) {
        return eventService.delete(id);
    }
}
