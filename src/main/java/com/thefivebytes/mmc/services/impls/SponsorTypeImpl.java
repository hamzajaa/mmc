package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.SponsorConverters;
import com.thefivebytes.mmc.converters.SponsorTypeConverters;
import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.dto.SponsorTypeDto;
import com.thefivebytes.mmc.entities.Sponsor;
import com.thefivebytes.mmc.entities.SponsorType;
import com.thefivebytes.mmc.repositories.SponsorTypeRepo;
import com.thefivebytes.mmc.services.facade.ISponsorTypeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorTypeImpl implements ISponsorTypeFacade {



    @Autowired
    private SponsorTypeRepo sponsorTypeRepo;

    @Override
    public Optional<SponsorTypeDto> findById(Long id) {
        Optional<SponsorType>  sponsorType= sponsorTypeRepo.findById(id);
        return Optional.of(SponsorTypeConverters.toDto(sponsorType.orElseThrow()));

    }

    @Override
    public Optional<List<SponsorTypeDto>> findAllSponsorType() {
        Optional<List<SponsorType>> sponsorTypes= Optional.of(sponsorTypeRepo.findAll());
        List<SponsorTypeDto> sponsorTypeDtos=sponsorTypes.get().stream().map(SponsorTypeConverters::toDto).toList();

        return Optional.of(sponsorTypeDtos);
    }

    @Override
    public Optional<SponsorTypeDto> addSponsorType(SponsorTypeDto sponsorTypeDto) {
        return Optional.of(SponsorTypeConverters.toDto(sponsorTypeRepo.save(SponsorTypeConverters.toEntity(sponsorTypeDto))));

    }

    @Override
    public Optional<SponsorTypeDto> updateSponsorType(SponsorTypeDto sponsorTypeDto) {
        return Optional.of(SponsorTypeConverters.toDto(sponsorTypeRepo.save(SponsorTypeConverters.toEntity(sponsorTypeDto))));
    }

    @Override
    public void deleteSponsor(Long id) {
        sponsorTypeRepo.deleteById(id);

    }
}
