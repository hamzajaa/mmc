package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.dto.SpeakerDTO;

import java.util.List;
import java.util.Optional;

public interface ISpeakerService {
    Optional<SpeakerDTO> findSpeakerById(Long id) ;
    Optional<List<SpeakerDTO>> findAllSpeakers() ;
    Optional<SpeakerDTO> addNewSpeaker(SpeakerDTO categoryDTO) ;
    Optional<SpeakerDTO> updateSpeaker(SpeakerDTO categoryDTO) ;
    void deleteSpeaker(Long id);
}
