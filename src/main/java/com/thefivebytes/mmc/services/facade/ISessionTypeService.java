package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.entities.SessionType;

import java.util.List;
import java.util.Optional;

public interface ISessionTypeService {

    List<SessionType> findAll();

    Optional<SessionType> findById(Long id);
    Optional<SessionType> findByLabel(String label);

    SessionType save(SessionType sessionType);

    SessionType update(SessionType sessionType);

    int delete(Long id);
}
