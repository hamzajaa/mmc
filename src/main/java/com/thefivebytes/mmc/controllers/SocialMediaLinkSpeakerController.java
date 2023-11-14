package com.thefivebytes.mmc.controllers;


import com.thefivebytes.mmc.dto.SocialMediaLinkSpeakerDTO;
import com.thefivebytes.mmc.services.impls.SocialMediaLinkSpeakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speakersMedia")
public class SocialMediaLinkSpeakerController {
    SocialMediaLinkSpeakerService socialMediaLinkSpeakerService ;

    public SocialMediaLinkSpeakerController(SocialMediaLinkSpeakerService socialMediaLinkSpeakerService) {
        this.socialMediaLinkSpeakerService = socialMediaLinkSpeakerService;
    }

    @GetMapping("/{id}")
    public SocialMediaLinkSpeakerDTO findSmlSpeakerById(@PathVariable Long id) {
        return socialMediaLinkSpeakerService.findSmlSpeakerById(id).orElseThrow() ;
    }

    @GetMapping
    public List<SocialMediaLinkSpeakerDTO> findAllSmlSpeakers() {
        return socialMediaLinkSpeakerService.findAllSocialMediaLinks().orElseThrow();
    }

    @PostMapping
    public  SocialMediaLinkSpeakerDTO addSmlSpeaker(@RequestBody SocialMediaLinkSpeakerDTO socialMediaLinkSpeakerDTO) {
        return socialMediaLinkSpeakerService.addNewSocialMediaLink(socialMediaLinkSpeakerDTO).orElseThrow() ;
    }

    @PutMapping
    public SocialMediaLinkSpeakerDTO updateSmlSpeaker(@RequestBody SocialMediaLinkSpeakerDTO socialMediaLinkSpeakerDTO) {
        return socialMediaLinkSpeakerService.updateSocialMediaLink(socialMediaLinkSpeakerDTO).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteSmlSpeaker(@PathVariable Long id) {
        socialMediaLinkSpeakerService.deleteSocialMediaLink(id);
    }
}
