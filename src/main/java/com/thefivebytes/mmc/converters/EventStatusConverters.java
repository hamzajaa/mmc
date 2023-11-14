package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.EventStatusDto;
import com.thefivebytes.mmc.entities.EventStatus;


public class EventStatusConverters {

  public static EventStatusDto toDto(EventStatus eventStatus){
      EventStatusDto eventStatusDto=new EventStatusDto();
      eventStatusDto.setId(eventStatus.getId());
      eventStatusDto.setLabel(eventStatus.getLabel());
      return eventStatusDto;

  }
    public static EventStatus toEntity(EventStatusDto eventStatusDto){
        EventStatus eventStatus=new EventStatus();
        eventStatus.setId(eventStatusDto.getId());
        eventStatus.setLabel(eventStatusDto.getLabel());
        return eventStatus;

    }

}
