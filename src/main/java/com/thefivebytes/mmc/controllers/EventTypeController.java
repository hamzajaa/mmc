package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.services.facade.IEventTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.thefivebytes.mmc.dto.EventTypeDTO;
import java.util.List;

@RequestMapping("/event-types")
@RestController
public class EventTypeController {

    private IEventTypeService iEventTypeService;

    public EventTypeController(IEventTypeService iEventTypeService) {
        this.iEventTypeService = iEventTypeService;
    }

    @GetMapping
    public List<EventTypeDTO> findAllEventTypes(){
        return iEventTypeService.findAllEventTypes().orElseThrow();
    }

    @GetMapping("/{id}")
    public EventTypeDTO findEventTypeById(@PathVariable long id){
        return iEventTypeService.findEventTypeById(id).orElseThrow();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventTypeDTO addEventType(@RequestBody EventTypeDTO eventTypeDTO){
        return iEventTypeService.addEventType(eventTypeDTO).orElseThrow();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventTypeDTO editEventType(@RequestBody EventTypeDTO eventTypeDTO){
        return iEventTypeService.editEventType(eventTypeDTO).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteEventType(@PathVariable long id){
        iEventTypeService.deleteEventType(id);
    }
}
