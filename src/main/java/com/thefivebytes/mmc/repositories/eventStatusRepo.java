package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.eventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventStatusRepo extends JpaRepository<eventStatus,Long> {
}
