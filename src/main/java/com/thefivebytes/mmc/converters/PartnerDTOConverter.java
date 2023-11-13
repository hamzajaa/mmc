package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.PartnerDTO;
import com.thefivebytes.mmc.entities.Partner;

public class PartnerDTOConverter {

    public static Partner partnerDtoToPartner(PartnerDTO partnerDTO) {
        Partner partner = new Partner() ;
        partner.setId(partnerDTO.getId());
        partner.setName(partnerDTO.getName());
        return partner ;
    }

    public static PartnerDTO partnerToPartnerDto(Partner partner) {
        PartnerDTO partnerDTO = new PartnerDTO() ;
        partnerDTO.setId(partner.getId());
        partnerDTO.setName(partner.getName());
        return partnerDTO ;
    }
}
