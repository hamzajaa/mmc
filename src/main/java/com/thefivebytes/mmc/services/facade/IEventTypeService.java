package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.EventTypeDTO;

import java.util.List;
import java.util.Optional;

public interface IEventTypeService {
    Optional<List<EventTypeDTO>> findAllEventTypes();
    Optional<EventTypeDTO> findEventTypeById(long id);
    Optional<EventTypeDTO> addEventType(EventTypeDTO eventTypeDTO);
    Optional<EventTypeDTO> editEventType(EventTypeDTO eventTypeDTO);
    void deleteEventType(long id);
}
