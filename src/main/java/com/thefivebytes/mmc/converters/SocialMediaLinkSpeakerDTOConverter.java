package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.SocialMediaLinkSpeakerDTO;
import com.thefivebytes.mmc.entities.SocialMediaLinkSpeaker;

public class SocialMediaLinkSpeakerDTOConverter {


    public static SocialMediaLinkSpeaker smlSpeakerDtoToSmlSpeaker(SocialMediaLinkSpeakerDTO socialMediaLinkSpeakerDTO) {
        SocialMediaLinkSpeaker smlSpeaker = new SocialMediaLinkSpeaker() ;
        smlSpeaker.setId(socialMediaLinkSpeakerDTO.getId());
        smlSpeaker.setSocialMediaLink(socialMediaLinkSpeakerDTO.getSocialMediaLink());
        return smlSpeaker ;
    }

    public static  SocialMediaLinkSpeakerDTO smlSpeakerToSmlSpeakerDto(SocialMediaLinkSpeaker socialMediaLinkSpeaker) {
        SocialMediaLinkSpeakerDTO smlSpeakerDto = new SocialMediaLinkSpeakerDTO() ;
        smlSpeakerDto.setId(socialMediaLinkSpeaker.getId());
        smlSpeakerDto.setSocialMediaLink(socialMediaLinkSpeaker.getSocialMediaLink());
        return smlSpeakerDto ;
    }
}
