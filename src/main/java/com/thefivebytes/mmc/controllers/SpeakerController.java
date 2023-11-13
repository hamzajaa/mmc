package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.dto.SpeakerDTO;
import com.thefivebytes.mmc.services.facade.ISpeakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {
    private final ISpeakerService speakerService ;

    public SpeakerController(ISpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping("/{id}")
    public SpeakerDTO findSpeakerById(@PathVariable Long id) {
        return speakerService.findSpeakerById(id).orElseThrow();
    }

    @GetMapping
    public List<SpeakerDTO> findAllSpeakers() {
        return speakerService.findAllSpeakers().orElseThrow() ;
    }

    @PostMapping
    public SpeakerDTO addSpeaker(@RequestBody SpeakerDTO speakerDTO) {
        return speakerService.addNewSpeaker(speakerDTO).orElseThrow();
    }

    @PutMapping
    public SpeakerDTO updateSpeaker(@RequestBody SpeakerDTO speakerDTO) {
        return speakerService.updateSpeaker(speakerDTO).orElseThrow() ;
    }

    @DeleteMapping("/{id}")
    public void deleteSpeaker(@PathVariable Long id) {
        speakerService.deleteSpeaker(id);
    }
}
