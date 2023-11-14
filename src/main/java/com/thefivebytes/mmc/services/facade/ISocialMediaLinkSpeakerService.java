package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.PartnerDTO;
import com.thefivebytes.mmc.dto.SocialMediaLinkSpeakerDTO;

import java.util.List;
import java.util.Optional;

public interface ISocialMediaLinkSpeakerService {
    Optional<SocialMediaLinkSpeakerDTO> findSmlSpeakerById(Long id) ;
    Optional<List<SocialMediaLinkSpeakerDTO>> findAllSocialMediaLinks() ;
    Optional<SocialMediaLinkSpeakerDTO> addNewSocialMediaLink(SocialMediaLinkSpeakerDTO PartnerDTO) ;
    Optional<SocialMediaLinkSpeakerDTO> updateSocialMediaLink(SocialMediaLinkSpeakerDTO partnerDTO) ;
    void deleteSocialMediaLink(Long id);
}
