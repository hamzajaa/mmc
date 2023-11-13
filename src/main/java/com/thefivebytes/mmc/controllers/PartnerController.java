package com.thefivebytes.mmc.controllers;


import com.thefivebytes.mmc.dto.PartnerDTO;
import com.thefivebytes.mmc.services.facade.IPartnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    private final IPartnerService partnerService ;


    public PartnerController(IPartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/{id}")
    public PartnerDTO findPartnerById(@PathVariable Long id) {
        return partnerService.findPartnerById(id).orElseThrow() ;
    }

    @GetMapping
    public List<PartnerDTO> findAllPartners(){
        return partnerService.findAllPartners().orElseThrow() ;
    }

    @PostMapping
    public PartnerDTO addPartner(@RequestBody PartnerDTO partnerDTO){
        return partnerService.addNewPartner(partnerDTO).orElseThrow() ;
    }

    @PutMapping
    public PartnerDTO updatePartner(@RequestBody PartnerDTO partnerDTO) {
        return partnerService.updatePartner(partnerDTO).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
    }

}
