package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.SessionTypeDto;
import com.thefivebytes.mmc.entities.SessionType;
import org.springframework.stereotype.Component;

@Component
public class SessionTypeConverter {

    public SessionType toEntity(SessionTypeDto dto) {
        SessionType entity = new SessionType();
        entity.setId(dto.getId());
        entity.setLabel(dto.getLabel());
        return entity;
    }

    public SessionTypeDto toDto(SessionType entity) {
        SessionTypeDto dto = new SessionTypeDto();
        dto.setId(entity.getId());
        dto.setLabel(entity.getLabel());
        return dto;
    }
}
