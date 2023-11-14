package com.thefivebytes.mmc.services.facade;


import com.thefivebytes.mmc.dto.EventSocialMediaLinkDTO;

import java.util.List;
import java.util.Optional;

public interface IEventSocialMediaLinkService {
    Optional<List<EventSocialMediaLinkDTO>> findAllEventSocialMediaLinks();
    Optional<EventSocialMediaLinkDTO> findEventSocialMediaLinkById(long id);
    Optional<EventSocialMediaLinkDTO> addEventSocialMediaLink(EventSocialMediaLinkDTO eventSocialMediaLinkDTO);
    Optional<EventSocialMediaLinkDTO> editEventSocialMediaLink(EventSocialMediaLinkDTO eventSocialMediaLinkDTO);
    void deleteEventSocialMediaLink(long id);
}
