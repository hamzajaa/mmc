package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.eventStatusDto;
import com.thefivebytes.mmc.entities.eventStatus;
import lombok.Builder;

@Builder
public class eventStatusConverters {

  public static eventStatusDto toDto(eventStatus eventStatus){
      eventStatusDto eventStatusDto=new eventStatusDto();
      eventStatusDto.setId(eventStatus.getId());
      eventStatusDto.setLabel(eventStatus.getLabel());
      return eventStatusDto;

  }
    public static eventStatus toEntity(eventStatusDto eventStatusDto){
        eventStatus eventStatus=new eventStatus();
        eventStatus.setId(eventStatusDto.getId());
        eventStatus.setLabel(eventStatusDto.getLabel());
        return eventStatus;

    }

}
