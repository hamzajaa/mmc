package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.dto.SponsorTypeDto;
import com.thefivebytes.mmc.services.impls.SponsorImpl;
import com.thefivebytes.mmc.services.impls.SponsorTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SponsorType")
public class SponsorTypeControllers {
    @Autowired
    private SponsorTypeImpl sponsorTypeImpl;


    @GetMapping("/{id}")
    public SponsorTypeDto findSponsorById(@PathVariable Long id) {
        return sponsorTypeImpl.findById(id).orElseThrow();
    }

    @GetMapping
    public List<SponsorTypeDto> findAllSponsors() {

        return sponsorTypeImpl.findAllSponsorType().orElseThrow() ;
    }

    @PostMapping
    public SponsorTypeDto addProvider(@RequestBody SponsorTypeDto p) {

        return sponsorTypeImpl.addSponsorType(p).orElseThrow() ;
    }

    @PutMapping
    public SponsorTypeDto updateProvider(@RequestBody SponsorTypeDto p) {
        return sponsorTypeImpl.updateSponsorType(p).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id){
        sponsorTypeImpl.deleteSponsor(id);
    }

}
