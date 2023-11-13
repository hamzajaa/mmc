package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.dto.eventStatusDto;
import com.thefivebytes.mmc.entities.Sponsor;
import com.thefivebytes.mmc.entities.eventStatus;

public class SponsorConverters {
    public static SponsorDto toDto(Sponsor sponsor){
        SponsorDto sponsorDto=new SponsorDto();
        sponsorDto.setId(sponsor.getId());
        sponsorDto.setNom(sponsor.getNom());
        sponsorDto.setDescription(sponsor.getDescription());
        return sponsorDto;

    }
    public static Sponsor toEntity(SponsorDto sponsorDto){
        Sponsor sponsor=new Sponsor();
        sponsor.setId(sponsorDto.getId());
        sponsor.setNom(sponsorDto.getNom());
        sponsor.setDescription(sponsorDto.getDescription());
        return sponsor;

    }
}
