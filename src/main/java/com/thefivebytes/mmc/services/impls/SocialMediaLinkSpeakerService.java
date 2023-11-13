package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.SocialMediaLinkSpeakerDTOConverter;
import com.thefivebytes.mmc.dto.SocialMediaLinkSpeakerDTO;
import com.thefivebytes.mmc.entities.SocialMediaLinkSpeaker;
import com.thefivebytes.mmc.repositories.ISocialMediaLinkSpeakerRepository;
import com.thefivebytes.mmc.services.facade.ISocialMediaLinkSpeakerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class SocialMediaLinkSpeakerService implements ISocialMediaLinkSpeakerService {
    private final ISocialMediaLinkSpeakerRepository socialMediaLinkSpeakerRepository;

    public SocialMediaLinkSpeakerService(ISocialMediaLinkSpeakerRepository socialMediaLinkSpeakerRepository) {
        this.socialMediaLinkSpeakerRepository = socialMediaLinkSpeakerRepository;
    }

    @Override
    public Optional<SocialMediaLinkSpeakerDTO> findSmlSpeakerById(Long id) {
        SocialMediaLinkSpeaker socialMediaLinkSpeaker = socialMediaLinkSpeakerRepository.findById(id).orElseThrow();
        return Optional.of(SocialMediaLinkSpeakerDTOConverter.smlSpeakerToSmlSpeakerDto(socialMediaLinkSpeaker));
    }

    @Override
    public Optional<List<SocialMediaLinkSpeakerDTO>> findAllSocialMediaLinks() {
        List<SocialMediaLinkSpeaker> socialMediaLinkSpeakers = socialMediaLinkSpeakerRepository.findAll();
        List<SocialMediaLinkSpeakerDTO> socialMediaLinkSpeakerDTOS = socialMediaLinkSpeakers.stream()
                .map(SocialMediaLinkSpeakerDTOConverter::smlSpeakerToSmlSpeakerDto).toList();
        return Optional.of(socialMediaLinkSpeakerDTOS);
    }

    @Override
    public Optional<SocialMediaLinkSpeakerDTO> addNewSocialMediaLink(@RequestBody  SocialMediaLinkSpeakerDTO socialMediaLinkSpeakerDTO) {
        SocialMediaLinkSpeaker socialMediaLinkSpeaker = SocialMediaLinkSpeakerDTOConverter.smlSpeakerDtoToSmlSpeaker(socialMediaLinkSpeakerDTO);
        return Optional.of(SocialMediaLinkSpeakerDTOConverter.smlSpeakerToSmlSpeakerDto(socialMediaLinkSpeakerRepository.save(socialMediaLinkSpeaker)));
    }

    @Override
    public Optional<SocialMediaLinkSpeakerDTO> updateSocialMediaLink(SocialMediaLinkSpeakerDTO socialMediaLinkSpeakerDTO) {
        if(findSmlSpeakerById(socialMediaLinkSpeakerDTO.getId()).isPresent()) {
            SocialMediaLinkSpeaker socialMediaLinkSpeaker = SocialMediaLinkSpeakerDTOConverter.smlSpeakerDtoToSmlSpeaker(socialMediaLinkSpeakerDTO) ;
            return Optional.of(SocialMediaLinkSpeakerDTOConverter.smlSpeakerToSmlSpeakerDto(socialMediaLinkSpeakerRepository.save(socialMediaLinkSpeaker)));
        }
        return Optional.empty();
    }

    @Override
    public void deleteSocialMediaLink(Long id) {
        if(findSmlSpeakerById(id).isPresent()){
            socialMediaLinkSpeakerRepository.deleteById(id);
        }
    }
}
