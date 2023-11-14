package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.dto.SponsorTypeDto;
import com.thefivebytes.mmc.entities.SponsorType;

import java.util.List;
import java.util.Optional;

public interface ISponsorTypeFacade {
    Optional<SponsorTypeDto> findById(Long id) ;
    Optional<List<SponsorTypeDto>> findAllSponsorType() ;
    Optional<SponsorTypeDto> addSponsorType(SponsorTypeDto p) ;
    Optional<SponsorTypeDto> updateSponsorType(SponsorTypeDto p) ;
    void deleteSponsor(Long id) ;
}
