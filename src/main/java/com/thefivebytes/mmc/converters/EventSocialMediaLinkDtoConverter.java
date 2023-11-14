package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.EventSocialMediaLinkDTO;
import com.thefivebytes.mmc.dto.EventTypeDTO;
import com.thefivebytes.mmc.entities.EventSocialMediaLink;
import com.thefivebytes.mmc.entities.EventType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Component;





public class EventSocialMediaLinkDtoConverter {


    public static EventSocialMediaLink eventSocialMediaLinkDtoToEventSocialMediaLink(EventSocialMediaLinkDTO eventSocialMediaLinkDTO) {
        EventSocialMediaLink eventSocialMediaLink = new EventSocialMediaLink();
        eventSocialMediaLink.setId(eventSocialMediaLinkDTO.getId());
        eventSocialMediaLink.setLabel(eventSocialMediaLinkDTO.getLabel());
        eventSocialMediaLink.setEvent(EventConverter.toEntity(eventSocialMediaLinkDTO.getEventDto()));
        return eventSocialMediaLink;
    }

    public static EventSocialMediaLinkDTO eventSocialMediaLinkToEventSocialMediaLinkDto(EventSocialMediaLink eventSocialMediaLink) {
        EventSocialMediaLinkDTO eventSocialMediaLinkDTO = new EventSocialMediaLinkDTO();
        eventSocialMediaLinkDTO.setId(eventSocialMediaLink.getId());
        eventSocialMediaLinkDTO.setLabel(eventSocialMediaLink.getLabel());
        eventSocialMediaLinkDTO.setEventDto(EventConverter.toDto(eventSocialMediaLink.getEvent()));
        return eventSocialMediaLinkDTO;
    }
}
