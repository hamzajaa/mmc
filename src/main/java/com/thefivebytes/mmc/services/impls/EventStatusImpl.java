package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.EventStatusConverters;
import com.thefivebytes.mmc.dto.EventStatusDto;
import com.thefivebytes.mmc.entities.EventStatus;
import com.thefivebytes.mmc.services.facade.EventStatusFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thefivebytes.mmc.repositories.eventStatusRepo;

import java.util.List;
import java.util.Optional;


@Service
public class EventStatusImpl implements EventStatusFacade {

    @Autowired
    private  eventStatusRepo eventStatusRepo;
    @Override
    public Optional<EventStatusDto> findById(Long id) {
        Optional<EventStatus>  user= eventStatusRepo.findById(id);
        return Optional.of( EventStatusConverters.toDto(user.orElseThrow()));
    }

    @Override
    public Optional<List<EventStatusDto>> findAllStatus() {
        Optional<List<EventStatus>> eventStatus= Optional.of(eventStatusRepo.findAll());
        List<EventStatusDto> eventStatusDto= eventStatus.get().stream().map(EventStatusConverters::toDto).toList();
        return Optional.of(eventStatusDto);
    }

    @Override
    public Optional<EventStatusDto> addStatus(EventStatusDto eventStatusDto) {
     return Optional.of(EventStatusConverters.toDto(eventStatusRepo.save(EventStatusConverters.toEntity(eventStatusDto))));
    }

    @Override
    public Optional<EventStatusDto> updateStatus(EventStatusDto eventStatusDto) {
        if(findById(eventStatusDto.getId()).isPresent()){
            return Optional.of(EventStatusConverters.toDto(eventStatusRepo.save(EventStatusConverters.toEntity(eventStatusDto))));
        }
        return Optional.empty();
    }

    @Override
    public void deleteStatus(Long id) {
           eventStatusRepo.deleteById(id);
    }
}
