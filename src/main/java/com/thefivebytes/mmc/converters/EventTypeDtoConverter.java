package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.EventTypeDTO;
import com.thefivebytes.mmc.entities.EventType;

public class EventTypeDtoConverter {
    public static EventType eventTypeDtoToEventType(EventTypeDTO eventTypeDTO){
        EventType eventType = new EventType();
        eventType.setId(eventTypeDTO.getId());
        eventType.setLabel(eventTypeDTO.getLabel());
        return eventType;
    }

    public static EventTypeDTO EventTypeToEventTypeDto(EventType eventType){
        EventTypeDTO eventTypeDTO = new EventTypeDTO();
        eventTypeDTO.setId(eventType.getId());
        eventTypeDTO.setLabel(eventType.getLabel());
        return eventTypeDTO;
    }
}
