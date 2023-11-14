package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.SponsorDto;

import java.util.List;
import java.util.Optional;

public interface ISponsorFacade {
    Optional<SponsorDto> findById(Long id) ;
    Optional<List<SponsorDto>> findAllSponsor() ;
    Optional<SponsorDto> addSponsor(SponsorDto p) ;
    Optional<SponsorDto> updateSponsor(SponsorDto p) ;
    void deleteSponsor(Long id) ;
}
