package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.PartnerDTOConverter;
import com.thefivebytes.mmc.dto.PartnerDTO;
import com.thefivebytes.mmc.entities.Partner;
import com.thefivebytes.mmc.repositories.IPartnerRepository;
import com.thefivebytes.mmc.services.facade.IPartnerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;



@Service
public class PartnerService implements IPartnerService {

    private final IPartnerRepository partnerRepository ;

    public PartnerService(IPartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Optional<PartnerDTO> findPartnerById(Long id) {
        Partner partner = partnerRepository.findById(id).orElseThrow();
        return Optional.of(PartnerDTOConverter.partnerToPartnerDto(partner));
    }

    @Override
    public Optional<List<PartnerDTO>> findAllPartners() {
        List<Partner> partners = partnerRepository.findAll();
        List<PartnerDTO> partnerDTOS = partners.stream().map(PartnerDTOConverter::partnerToPartnerDto).toList();
        return Optional.of(partnerDTOS) ;
    }

    @Override
    public Optional<PartnerDTO> addNewPartner(@RequestBody PartnerDTO partnerDTO) {
        Partner partner = PartnerDTOConverter.partnerDtoToPartner(partnerDTO) ;
        return Optional.of(PartnerDTOConverter.partnerToPartnerDto(partnerRepository.save(partner)));
    }

    @Override
    public Optional<PartnerDTO> updatePartner(PartnerDTO partnerDTO) {
        if (findPartnerById(partnerDTO.getId()).isPresent()) {
            Partner partner = PartnerDTOConverter.partnerDtoToPartner(partnerDTO) ;
            return Optional.of(PartnerDTOConverter.partnerToPartnerDto(partnerRepository.save(partner)));
        }
        return Optional.empty() ;
    }

    @Override
    public void deletePartner(Long id) {
        if(findPartnerById(id).isPresent()) {
            partnerRepository.deleteById(id);
        }
    }
}
