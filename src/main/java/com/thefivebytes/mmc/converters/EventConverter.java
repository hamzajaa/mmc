package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.EventDto;
import com.thefivebytes.mmc.dto.SessionTypeDto;
import com.thefivebytes.mmc.entities.Event;
import com.thefivebytes.mmc.entities.SessionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class EventConverter {


    public static Event toEntity(EventDto dto) {
        Event entity = new Event();
        if (dto == null) {
            return null;
        } else {

            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            entity.setAddress(dto.getAddress());
            entity.setNbOfPlace(dto.getNbOfPlace());
            entity.setCategory(CategoryDTOConverter.categoryDtoToCategory(dto.getCategoryDTO()));
            entity.setEventVille(EventVilleDTOConverter.dtoToEntity(dto.getEventVilleDTO()));
            entity.setEventType(EventTypeDtoConverter.eventTypeDtoToEventType(dto.getEventTypeDTO()));
            entity.setEventStatus(EventStatusConverters.toEntity(dto.getEventStatusDto()));

            return entity;
        }
    }

    public static EventDto toDto(Event entity) {
        if (entity == null) {
            return null;
        } else {
            EventDto dto = new EventDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setStartDate(entity.getStartDate());
            dto.setEndDate(entity.getEndDate());
            dto.setAddress(entity.getAddress());
            dto.setNbOfPlace(entity.getNbOfPlace());
            dto.setCategoryDTO(CategoryDTOConverter.categoryToCategoryDto(entity.getCategory()));
            dto.setEventVilleDTO(EventVilleDTOConverter.entityToDTO(entity.getEventVille()));
            dto.setEventTypeDTO(EventTypeDtoConverter.EventTypeToEventTypeDto(entity.getEventType()));
            dto.setEventStatusDto(EventStatusConverters.toDto(entity.getEventStatus()));

            return dto;
        }
    }

    public static List<EventDto> toDto(List<Event> entities){
        List<EventDto> dtos = new ArrayList<>();
        for (Event entity : entities) {
            EventDto dto = toDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
