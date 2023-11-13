package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.EventTypeDtoConverter;
import com.thefivebytes.mmc.dto.EventTypeDTO;
import com.thefivebytes.mmc.entities.EventType;
import com.thefivebytes.mmc.repositories.IEventTypeRepositoery;
import com.thefivebytes.mmc.services.facade.IEventTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypeService implements IEventTypeService {
    private IEventTypeRepositoery iEventTypeRepositoery;

    public EventTypeService(IEventTypeRepositoery iEventTypeRepositoery) {
        this.iEventTypeRepositoery = iEventTypeRepositoery;
    }

    @Override
    public Optional<List<EventTypeDTO>> findAllEventTypes() {
        List<EventType> eventTypes = iEventTypeRepositoery.findAll();
        List<EventTypeDTO> eventTypeDTOS = eventTypes.stream().map(EventTypeDtoConverter::EventTypeToEventTypeDto).toList();
        return Optional.of(eventTypeDTOS);
    }

    @Override
    public Optional<EventTypeDTO> findEventTypeById(long id) {
        EventType eventType = iEventTypeRepositoery.findById(id).orElseThrow();
        return Optional.of(EventTypeDtoConverter.EventTypeToEventTypeDto(eventType));
    }

    @Override
    public Optional<EventTypeDTO> addEventType(EventTypeDTO eventTypeDTO) {
        EventType eventType = EventTypeDtoConverter.eventTypeDtoToEventType(eventTypeDTO);
        return Optional.of(EventTypeDtoConverter.EventTypeToEventTypeDto(iEventTypeRepositoery.save(eventType)));
    }

    @Override
    public Optional<EventTypeDTO> editEventType(EventTypeDTO eventTypeDTO) {
        if(this.findEventTypeById(eventTypeDTO.getId()).isPresent()){
            return this.addEventType(eventTypeDTO);
        }
        return Optional.empty();
    }

    @Override
    public void deleteEventType(long id) {
        iEventTypeRepositoery.deleteById(id);
    }
}
