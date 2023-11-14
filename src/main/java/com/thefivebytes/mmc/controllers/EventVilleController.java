package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.dto.EventVilleDTO;
import com.thefivebytes.mmc.services.facade.IEventVilleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/event-villes")
@RestController
public class EventVilleController {
    private IEventVilleService iEventVilleService;

    public EventVilleController(IEventVilleService iEventVilleService) {
        this.iEventVilleService = iEventVilleService;
    }
    @GetMapping
    public List<EventVilleDTO> findAllEventVilles(){
        return iEventVilleService.findAllEventVilles().orElseThrow();
    }
    @GetMapping("/{id}")
    public EventVilleDTO findEventVilleById(@PathVariable long id){
        return iEventVilleService.findEventVilleById(id).orElseThrow();
    }
    @PostMapping
    public EventVilleDTO addEventVille(@RequestBody EventVilleDTO eventVilleDTO){
        return iEventVilleService.addEventVille(eventVilleDTO).orElseThrow();
    }

    @PutMapping
    public EventVilleDTO updateEventVille(@RequestBody EventVilleDTO eventVilleDTO){
        return iEventVilleService.updateEventVille(eventVilleDTO).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteEventVille(@PathVariable long id){
        iEventVilleService.deleteEventVille(id);
    }
}
