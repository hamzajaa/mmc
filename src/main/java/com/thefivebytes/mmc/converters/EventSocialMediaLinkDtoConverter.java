package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.EventSocialMediaLinkDTO;
import com.thefivebytes.mmc.dto.EventTypeDTO;
import com.thefivebytes.mmc.entities.EventSocialMediaLink;
import com.thefivebytes.mmc.entities.EventType;

public class EventSocialMediaLinkDtoConverter {
    public static EventSocialMediaLink eventSocialMediaLinkDtoToEventSocialMediaLink(EventSocialMediaLinkDTO eventSocialMediaLinkDTO){
        EventSocialMediaLink eventSocialMediaLink = new EventSocialMediaLink();
        eventSocialMediaLink.setId(eventSocialMediaLinkDTO.getId());
        eventSocialMediaLink.setLabel(eventSocialMediaLinkDTO.getLabel());
        return eventSocialMediaLink;
    }

    public static EventSocialMediaLinkDTO eventSocialMediaLinkToEventSocialMediaLinkDto(EventSocialMediaLink eventSocialMediaLink){
        EventSocialMediaLinkDTO eventSocialMediaLinkDTO = new EventSocialMediaLinkDTO();
        eventSocialMediaLinkDTO.setId(eventSocialMediaLink.getId());
        eventSocialMediaLinkDTO.setLabel(eventSocialMediaLink.getLabel());
        return eventSocialMediaLinkDTO;
    }
}
