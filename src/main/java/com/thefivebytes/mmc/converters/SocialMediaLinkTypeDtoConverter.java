package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.SocialMediaLinkTypeDTO;
import com.thefivebytes.mmc.entities.SocialMediaLinkType;

public class SocialMediaLinkTypeDtoConverter {
    public static SocialMediaLinkType socialMediaLinkTypeDtoToSocialMediaLinkType(SocialMediaLinkTypeDTO socialMediaLinkTypeDTO){
        SocialMediaLinkType socialMediaLinkType = new SocialMediaLinkType();
        socialMediaLinkType.setId(socialMediaLinkTypeDTO.getId());
        socialMediaLinkType.setLabel(socialMediaLinkTypeDTO.getLabel());
        return socialMediaLinkType;
    }

    public static SocialMediaLinkTypeDTO socialMediaLinkTypeToSocialMediaLinkTypeDto(SocialMediaLinkType socialMediaLinkType){
        SocialMediaLinkTypeDTO socialMediaLinkTypeDTO = new SocialMediaLinkTypeDTO();
        socialMediaLinkTypeDTO.setId(socialMediaLinkType.getId());
        socialMediaLinkTypeDTO.setLabel(socialMediaLinkType.getLabel());
        return socialMediaLinkTypeDTO;
    }
}
