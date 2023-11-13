package com.thefivebytes.mmc.services.impls;


import com.thefivebytes.mmc.converters.SpeakerDTOConverter;
import com.thefivebytes.mmc.dto.SpeakerDTO;
import com.thefivebytes.mmc.entities.Speaker;
import com.thefivebytes.mmc.repositories.ISpeakerRepository;
import com.thefivebytes.mmc.services.facade.ISpeakerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class SpeakerService implements ISpeakerService {

    private final ISpeakerRepository speakerRepository ;

    public SpeakerService(ISpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public Optional<SpeakerDTO> findSpeakerById(Long id) {
        Speaker speaker = speakerRepository.findById(id).orElseThrow();
        return Optional.of(SpeakerDTOConverter.speakerToSpeakerDto(speaker));
    }

    @Override
    public Optional<List<SpeakerDTO>> findAllSpeakers() {
        List<Speaker> speakers = speakerRepository.findAll() ;
        List<SpeakerDTO> speakerDTOS = speakers.stream().map(SpeakerDTOConverter::speakerToSpeakerDto).toList() ;
        return Optional.of(speakerDTOS) ;
    }

    @Override
    public Optional<SpeakerDTO> addNewSpeaker(@RequestBody SpeakerDTO speakerDTO) {
        Speaker speaker = SpeakerDTOConverter.speakerDtoToSpeaker(speakerDTO);
        return Optional.of(SpeakerDTOConverter.speakerToSpeakerDto(speakerRepository.save(speaker)));
    }

    @Override
    public Optional<SpeakerDTO> updateSpeaker(SpeakerDTO speakerDTO) {
        if(findSpeakerById(speakerDTO.getId()).isPresent()) {
            Speaker speaker = SpeakerDTOConverter.speakerDtoToSpeaker(speakerDTO) ;
            return Optional.of(SpeakerDTOConverter.speakerToSpeakerDto(speakerRepository.save(speaker)));
        }
        return Optional.empty();
    }

    @Override
    public void deleteSpeaker(Long id) {
        if(findSpeakerById(id).isPresent()){
            speakerRepository.deleteById(id);
        }
    }
}
