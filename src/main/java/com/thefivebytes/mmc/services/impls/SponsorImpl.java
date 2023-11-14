package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.SponsorConverters;
import com.thefivebytes.mmc.dto.SponsorDto;
import com.thefivebytes.mmc.entities.Sponsor;
import com.thefivebytes.mmc.repositories.SponsorRepo;
import com.thefivebytes.mmc.services.facade.ISponsorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorImpl implements ISponsorFacade {

    @Autowired
    private SponsorRepo sponsorRepo;
    @Override
    public Optional<SponsorDto> findById(Long id) {
        Optional<Sponsor>  sponsor= sponsorRepo.findById(id);

        return Optional.of( SponsorConverters.toDto(sponsor.orElseThrow()));

    }

    @Override
    public Optional<List<SponsorDto>> findAllSponsor() {
        Optional<List<Sponsor>> sponsor= Optional.of(sponsorRepo.findAll());
        List<SponsorDto> sponsorDto=sponsor.get().stream().map(SponsorConverters::toDto).toList();

        return Optional.of(sponsorDto);
    }

    @Override
    public Optional<SponsorDto> addSponsor(SponsorDto sponsorDto) {
        return Optional.of(SponsorConverters.toDto(sponsorRepo.save(SponsorConverters.toEntity(sponsorDto))));
    }

    @Override
    public Optional<SponsorDto> updateSponsor(SponsorDto sponsorDto) {

        return Optional.of(SponsorConverters.toDto(sponsorRepo.save(SponsorConverters.toEntity(sponsorDto))));

    }

    @Override
    public void deleteSponsor(Long id) {
        sponsorRepo.deleteById(id);

    }
}
