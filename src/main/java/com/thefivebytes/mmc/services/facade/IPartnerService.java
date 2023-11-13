package com.thefivebytes.mmc.services.facade;
import com.thefivebytes.mmc.dto.PartnerDTO;

import java.util.List;
import java.util.Optional;

public interface IPartnerService {
    Optional<PartnerDTO> findPartnerById(Long id) ;
    Optional<List<PartnerDTO>> findAllPartners() ;
    Optional<PartnerDTO> addNewPartner(PartnerDTO PartnerDTO) ;
    Optional<PartnerDTO> updatePartner(PartnerDTO partnerDTO) ;
    void deletePartner(Long id);
}
