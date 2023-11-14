package com.thefivebytes.mmc.dto;

import com.thefivebytes.mmc.entities.*;
import com.thefivebytes.mmc.security.bean.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class EventDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String address;
    private int nbOfPlace;
    private CategoryDTO categoryDTO;
    private EventVilleDTO eventVilleDTO;
    private EventTypeDTO eventTypeDTO;
    private EventStatusDto eventStatusDto;
//    private List<EventSocialMediaLinkDTO> eventSocialMediaLinkDTOS;
//    private List<User> users;
//    private List<SponsorDto> sponsorDtos;
//    private List<PartnerDTO> partnerDTOS;
}
