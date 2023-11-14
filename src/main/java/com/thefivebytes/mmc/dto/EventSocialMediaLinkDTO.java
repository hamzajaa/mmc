package com.thefivebytes.mmc.dto;

import com.thefivebytes.mmc.entities.Event;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class EventSocialMediaLinkDTO {
    private long id;
    private String label;
    private EventDto eventDto;
}
