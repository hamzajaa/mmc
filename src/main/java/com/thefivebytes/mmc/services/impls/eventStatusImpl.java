package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.eventStatusConverters;
import com.thefivebytes.mmc.dto.eventStatusDto;
import com.thefivebytes.mmc.entities.eventStatus;
import com.thefivebytes.mmc.services.facade.eventStatusFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thefivebytes.mmc.repositories.eventStatusRepo;

import java.util.List;
import java.util.Optional;


@Service
public class eventStatusImpl implements eventStatusFacade {

    @Autowired
    private  eventStatusRepo eventStatusRepo;
    @Override
    public Optional<eventStatusDto> findById(Long id) {
        Optional<eventStatus>  user= eventStatusRepo.findById(id);
        return Optional.of( eventStatusConverters.toDto(user.orElseThrow()));
    }

    @Override
    public Optional<List<eventStatusDto>> findAllStatus() {
        Optional<List<eventStatus>> eventStatus= Optional.of(eventStatusRepo.findAll());
        List<eventStatusDto> eventStatusDto= eventStatus.get().stream().map(eventStatusConverters::toDto).toList();
        return Optional.of(eventStatusDto);
    }

    @Override
    public Optional<eventStatusDto> addStatus(eventStatusDto eventStatusDto) {
     return Optional.of(eventStatusConverters.toDto(eventStatusRepo.save(eventStatusConverters.toEntity(eventStatusDto))));
    }

    @Override
    public Optional<eventStatusDto> updateStatus(eventStatusDto eventStatusDto) {
        if(findById(eventStatusDto.getId()).isPresent()){
            return Optional.of(eventStatusConverters.toDto(eventStatusRepo.save(eventStatusConverters.toEntity(eventStatusDto))));
        }
        return Optional.empty();
    }

    @Override
    public void deleteStatus(Long id) {
           eventStatusRepo.deleteById(id);
    }
}
