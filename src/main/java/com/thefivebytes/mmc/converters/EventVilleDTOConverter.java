package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.EventVilleDTO;
import com.thefivebytes.mmc.entities.EventVille;

import java.util.Optional;

public class EventVilleDTOConverter {
    public static EventVille dtoToEntity(EventVilleDTO eventVilleDTO){
        EventVille eventVille=new EventVille();
        eventVille.setId(eventVilleDTO.getId());
        eventVille.setLabel(eventVilleDTO.getLabel());
        return eventVille;
    }
    public static EventVilleDTO entityToDTO(EventVille eventVille){
        EventVilleDTO dto=new EventVilleDTO();
        dto.setId(eventVille.getId());
        dto.setLabel(eventVille.getLabel());
        return dto;
    }
}
