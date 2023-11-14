package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.SocialMediaLinkTypeDtoConverter;
import com.thefivebytes.mmc.dto.SocialMediaLinkTypeDTO;
import com.thefivebytes.mmc.entities.SocialMediaLinkType;
import com.thefivebytes.mmc.repositories.ISocialMediaLinkTypeRepository;
import com.thefivebytes.mmc.services.facade.ISocialMediaLinkTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaLinkTypeService implements ISocialMediaLinkTypeService {
    private ISocialMediaLinkTypeRepository iSocialMediaLinkTypeRepository;

    public SocialMediaLinkTypeService(ISocialMediaLinkTypeRepository iSocialMediaLinkTypeRepository) {
        this.iSocialMediaLinkTypeRepository = iSocialMediaLinkTypeRepository;
    }

    @Override
    public Optional<List<SocialMediaLinkTypeDTO>> findAllSocialMediaLinkTypes() {
        List<SocialMediaLinkType> socialMediaLinkTypes = iSocialMediaLinkTypeRepository.findAll();
        List<SocialMediaLinkTypeDTO> socialMediaLinkTypeDTOS = socialMediaLinkTypes.stream().map(SocialMediaLinkTypeDtoConverter::socialMediaLinkTypeToSocialMediaLinkTypeDto).toList();
        return Optional.of(socialMediaLinkTypeDTOS);
    }

    @Override
    public Optional<SocialMediaLinkTypeDTO> findSocialMediaLinkTypeById(long id) {
        SocialMediaLinkType socialMediaLinkType = iSocialMediaLinkTypeRepository.findById(id).orElseThrow();
        return Optional.of(SocialMediaLinkTypeDtoConverter.socialMediaLinkTypeToSocialMediaLinkTypeDto(socialMediaLinkType));
    }

    @Override
    public Optional<SocialMediaLinkTypeDTO> addSocialMediaLinkType(SocialMediaLinkTypeDTO socialMediaLinkTypeDTO) {
        SocialMediaLinkType socialMediaLink = SocialMediaLinkTypeDtoConverter.socialMediaLinkTypeDtoToSocialMediaLinkType(socialMediaLinkTypeDTO);
        return Optional.of(SocialMediaLinkTypeDtoConverter.socialMediaLinkTypeToSocialMediaLinkTypeDto(iSocialMediaLinkTypeRepository.save(socialMediaLink)));
    }

    @Override
    public Optional<SocialMediaLinkTypeDTO> editSocialMediaLinkType(SocialMediaLinkTypeDTO socialMediaLinkTypeDTO) {
        if(this.findSocialMediaLinkTypeById(socialMediaLinkTypeDTO.getId()).isPresent()){
            return this.addSocialMediaLinkType(socialMediaLinkTypeDTO);
        }
        return Optional.empty();
    }

    @Override
    public void deleteSocialMediaLinkType(long id) {
        iSocialMediaLinkTypeRepository.deleteById(id);
    }

}
