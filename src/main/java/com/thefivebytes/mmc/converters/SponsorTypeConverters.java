package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.dto.SponsorTypeDto;
import com.thefivebytes.mmc.entities.Sponsor;
import com.thefivebytes.mmc.entities.SponsorType;

public class SponsorTypeConverters {

    public static SponsorTypeDto toDto(SponsorType sponsorType){
        SponsorTypeDto sponsorTypeDto=new  SponsorTypeDto();
        sponsorTypeDto.setId(sponsorType.getId());
        sponsorTypeDto.setNom_du_type(sponsorType.getNom_du_type());
        sponsorTypeDto.setDescription(sponsorType.getDescription());
        return sponsorTypeDto;

    }
    public static SponsorType toEntity(SponsorTypeDto sponsorTypeDto){
        SponsorType sponsorType=new SponsorType();
        sponsorType.setId(sponsorTypeDto.getId());
        sponsorType.setNom_du_type(sponsorTypeDto.getNom_du_type());
        sponsorType.setDescription(sponsorTypeDto.getDescription());
        return sponsorType;

    }
}
