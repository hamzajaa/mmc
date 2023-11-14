package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.dto.EventSocialMediaLinkDTO;
import com.thefivebytes.mmc.services.facade.IEventSocialMediaLinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/social-medial-links")
@RestController
public class EventSocialMediaLinkController {
    private IEventSocialMediaLinkService iEventSocialMediaLinkService;

    public EventSocialMediaLinkController(IEventSocialMediaLinkService iEventSocialMediaLinkService) {
        this.iEventSocialMediaLinkService = iEventSocialMediaLinkService;
    }

    @GetMapping
    public List<EventSocialMediaLinkDTO> findAllEventSocialMediaLinks(){
        return iEventSocialMediaLinkService.findAllEventSocialMediaLinks().orElseThrow();
    }

    @GetMapping("/{id}")
    public EventSocialMediaLinkDTO findEventSocialMediaLinkById(@PathVariable long id){
        return iEventSocialMediaLinkService.findEventSocialMediaLinkById(id).orElseThrow();
    }


    @PostMapping
    public EventSocialMediaLinkDTO addEventSocialMediaLink(@RequestBody EventSocialMediaLinkDTO eventSocialMediaLinkDTO){
        return iEventSocialMediaLinkService.addEventSocialMediaLink(eventSocialMediaLinkDTO).orElseThrow();
    }

    @PutMapping
    public EventSocialMediaLinkDTO editEventSocialMediaLink(@RequestBody EventSocialMediaLinkDTO eventSocialMediaLinkDTO){
        return iEventSocialMediaLinkService.editEventSocialMediaLink(eventSocialMediaLinkDTO).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteEventSocialMediaLink(@PathVariable long id){
        iEventSocialMediaLinkService.deleteEventSocialMediaLink(id);
    }
}
