package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.EventSocialMediaLinkDtoConverter;
import com.thefivebytes.mmc.converters.EventTypeDtoConverter;
import com.thefivebytes.mmc.dto.EventSocialMediaLinkDTO;
import com.thefivebytes.mmc.dto.EventTypeDTO;
import com.thefivebytes.mmc.entities.EventSocialMediaLink;
import com.thefivebytes.mmc.entities.EventType;
import com.thefivebytes.mmc.repositories.IEventSocialMediaLinkRepository;
import com.thefivebytes.mmc.services.facade.IEventSocialMediaLinkService;
import com.thefivebytes.mmc.services.facade.IEventTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventSocialLinkService implements IEventSocialMediaLinkService {
    private IEventSocialMediaLinkRepository iEventSocialMediaLinkRepository;

    public EventSocialLinkService(IEventSocialMediaLinkRepository iEventSocialMediaLinkRepository) {
        this.iEventSocialMediaLinkRepository = iEventSocialMediaLinkRepository;
    }

    @Override
    public Optional<List<EventSocialMediaLinkDTO>> findAllEventSocialMediaLinks() {
        List<EventSocialMediaLink> eventTypes = iEventSocialMediaLinkRepository.findAll();
        List<EventSocialMediaLinkDTO> eventTypeDTOS = eventTypes.stream().map(EventSocialMediaLinkDtoConverter::eventSocialMediaLinkToEventSocialMediaLinkDto).toList();
        return Optional.of(eventTypeDTOS);
    }

    @Override
    public Optional<EventSocialMediaLinkDTO> findEventSocialMediaLinkById(long id) {
        EventSocialMediaLink eventSocialMediaLink = iEventSocialMediaLinkRepository.findById(id).orElseThrow();
        return Optional.of(EventSocialMediaLinkDtoConverter.eventSocialMediaLinkToEventSocialMediaLinkDto(eventSocialMediaLink));
    }

    @Override
    public Optional<EventSocialMediaLinkDTO> addEventSocialMediaLink(EventSocialMediaLinkDTO eventSocialMediaLinkDTO) {
        System.out.println(eventSocialMediaLinkDTO);
        EventSocialMediaLink eventSocialMediaLink = EventSocialMediaLinkDtoConverter.eventSocialMediaLinkDtoToEventSocialMediaLink(eventSocialMediaLinkDTO);
        System.out.println(eventSocialMediaLink);
        return Optional.of(EventSocialMediaLinkDtoConverter.eventSocialMediaLinkToEventSocialMediaLinkDto(iEventSocialMediaLinkRepository.save(eventSocialMediaLink)));
    }

    @Override
    public Optional<EventSocialMediaLinkDTO> editEventSocialMediaLink(EventSocialMediaLinkDTO eventSocialMediaLinkDTO) {
        if(this.findEventSocialMediaLinkById(eventSocialMediaLinkDTO.getId()).isPresent()){
            return this.addEventSocialMediaLink(eventSocialMediaLinkDTO);
        }
        return Optional.empty();
    }

    @Override
    public void deleteEventSocialMediaLink(long id) {
        iEventSocialMediaLinkRepository.deleteById(id);
    }
}
