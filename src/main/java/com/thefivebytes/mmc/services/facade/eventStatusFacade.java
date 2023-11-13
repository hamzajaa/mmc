package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.eventStatusDto;

import java.util.List;
import java.util.Optional;

public interface eventStatusFacade {
    Optional<eventStatusDto> findById(Long id) ;
    Optional<List<eventStatusDto>> findAllStatus() ;
    Optional<eventStatusDto> addStatus(eventStatusDto p) ;
    Optional<eventStatusDto> updateStatus(eventStatusDto p) ;
    void deleteStatus(Long id) ;
}
