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
    private EventConverter eventConverter;

    public EventController(IEventService eventService, EventConverter eventConverter) {
        this.eventService = eventService;
        this.eventConverter = eventConverter;
    }

    @GetMapping("/")
    public List<EventDto> findAll() {
        return eventConverter.toDto(eventService.findAll());
    }

    @GetMapping("/id/{id}")
    public EventDto findById(@PathVariable Long id) {
        return eventConverter.toDto(eventService.findById(id).get());
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventDto save(@RequestBody EventDto eventDto) {
        Event entity = eventConverter.toEntity(eventDto);
        entity = eventService.save(entity);
        return eventConverter.toDto(entity);
    }

    @PutMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventDto update(@RequestBody EventDto eventDto) {
        Event entity = eventConverter.toEntity(eventDto);
        entity = eventService.update(entity);
        return eventConverter.toDto(entity);

    }

    @DeleteMapping("/id/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public int delete(@PathVariable Long id) {
        return eventService.delete(id);
    }
}
