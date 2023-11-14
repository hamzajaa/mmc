package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.dto.SocialMediaLinkTypeDTO;
import com.thefivebytes.mmc.services.facade.ISocialMediaLinkTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/social-medial-link-types")
@RestController
public class SocialMediaLinkTypeController {
    private ISocialMediaLinkTypeService iSocialMediaLinkTypeService;

    public SocialMediaLinkTypeController(ISocialMediaLinkTypeService iSocialMediaLinkTypeService) {
        this.iSocialMediaLinkTypeService = iSocialMediaLinkTypeService;
    }

    @GetMapping
    public List<SocialMediaLinkTypeDTO> findAllSocialMediaLinkTypes(){
        return iSocialMediaLinkTypeService.findAllSocialMediaLinkTypes().orElseThrow();
    }

    @GetMapping("/{id}")
    public SocialMediaLinkTypeDTO findSocialMediaLinkTypeById(@PathVariable long id){
        return iSocialMediaLinkTypeService.findSocialMediaLinkTypeById(id).orElseThrow();
    }

    @PostMapping
    public SocialMediaLinkTypeDTO addSocialMediaLinkType(@RequestBody SocialMediaLinkTypeDTO socialMediaLinkTypeDTO){
        return iSocialMediaLinkTypeService.addSocialMediaLinkType(socialMediaLinkTypeDTO).orElseThrow();
    }

    @PutMapping
    public SocialMediaLinkTypeDTO editSocialMediaLinkType(@RequestBody SocialMediaLinkTypeDTO socialMediaLinkTypeDTO){
        return iSocialMediaLinkTypeService.editSocialMediaLinkType(socialMediaLinkTypeDTO).orElseThrow();
    }
    @DeleteMapping("/{id}")
    public void deleteSocialMediaLinkType(@PathVariable long id){
        iSocialMediaLinkTypeService.deleteSocialMediaLinkType(id);
    }
}
