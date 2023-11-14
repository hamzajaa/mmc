package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.services.impls.SponsorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sponsor")
public class SponsorControllers {

    @Autowired
    private SponsorImpl sponsorImpl;


    @GetMapping("/{id}")
    public SponsorDto findSponsorById(@PathVariable Long id) {
        return sponsorImpl.findById(id).orElseThrow();
    }

    @GetMapping
    public List<SponsorDto> findAllSponsors() {
        return sponsorImpl.findAllSponsor().orElseThrow() ;
    }

    @PostMapping
    public SponsorDto addPSponsor(@RequestBody SponsorDto p) {

        return sponsorImpl.addSponsor(p).orElseThrow() ;
    }

    @PutMapping
    public SponsorDto updateSponsors(@RequestBody SponsorDto p) {
        return sponsorImpl.updateSponsor(p).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteSponsors(@PathVariable Long id){

        sponsorImpl.deleteSponsor(id);
    }
}
