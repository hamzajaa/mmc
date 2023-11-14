package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.EventStatusDto;

import java.util.List;
import java.util.Optional;

public interface EventStatusFacade {
    Optional<EventStatusDto> findById(Long id) ;
    Optional<List<EventStatusDto>> findAllStatus() ;
    Optional<EventStatusDto> addStatus(EventStatusDto p) ;
    Optional<EventStatusDto> updateStatus(EventStatusDto p) ;
    void deleteStatus(Long id) ;
}
