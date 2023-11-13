package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.SocialMediaLinkTypeDTO;
import com.thefivebytes.mmc.entities.SocialMediaLinkType;

import java.util.List;
import java.util.Optional;

public interface ISocialMediaLinkTypeService {
    Optional<List<SocialMediaLinkTypeDTO>> findAllSocialMediaLinkTypes();
    Optional<SocialMediaLinkTypeDTO> findSocialMediaLinkTypeById(long id);
    Optional<SocialMediaLinkTypeDTO> addSocialMediaLinkType(SocialMediaLinkTypeDTO socialMediaLinkTypeDTO);
    Optional<SocialMediaLinkTypeDTO> editSocialMediaLinkType(SocialMediaLinkTypeDTO socialMediaLinkTypeDTO);
    void deleteSocialMediaLinkType(long id);
}
