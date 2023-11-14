package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.EventVilleDTOConverter;
import com.thefivebytes.mmc.dto.EventVilleDTO;
import com.thefivebytes.mmc.entities.EventVille;
import com.thefivebytes.mmc.repositories.IEventVilleRepository;
import com.thefivebytes.mmc.services.facade.IEventVilleService;

import java.util.List;
import java.util.Optional;

public class EventVilleServiceImpl implements IEventVilleService {

    private final IEventVilleRepository iEventVilleRepository;

    public EventVilleServiceImpl(IEventVilleRepository iEventVilleRepository) {
        this.iEventVilleRepository=iEventVilleRepository;
    }

    @Override
    public Optional<EventVilleDTO> findEventVilleById(Long id) {
       EventVille eventVille=iEventVilleRepository.findById(id).orElseThrow();
        return Optional.of(EventVilleDTOConverter.entityToDTO(eventVille));
    }

    @Override
    public Optional<List<EventVilleDTO>> findAllEventVilles() {
        List<EventVille> eventVilleList=iEventVilleRepository.findAll();
        List<EventVilleDTO> eventVilleDTOS=eventVilleList.stream().map(EventVilleDTOConverter::entityToDTO).toList();
        return Optional.of(eventVilleDTOS);
    }

    @Override
    public Optional<EventVilleDTO> addEventVille(EventVilleDTO eventVilleDTO) {
       EventVille eventVille=EventVilleDTOConverter.dtoToEntity(eventVilleDTO);
       return Optional.of(EventVilleDTOConverter.entityToDTO(iEventVilleRepository.save(eventVille)));
    }

    @Override
    public Optional<EventVilleDTO> updateEventVille(EventVilleDTO eventVilleDTO) {
        if(this.findEventVilleById(eventVilleDTO.getId()).isPresent()){
            return this.addEventVille(eventVilleDTO);
        }
        return Optional.empty();
    }

    @Override
    public void deleteEventVille(Long id) {
        iEventVilleRepository.deleteById(id);
    }
}
