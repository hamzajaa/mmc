package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.SessionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionTypeRepository extends JpaRepository<SessionType, Long> {
    Optional<SessionType> findByLabel(String label);
}
