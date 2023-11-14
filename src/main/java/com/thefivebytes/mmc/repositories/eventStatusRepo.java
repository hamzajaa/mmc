package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventStatusRepo extends JpaRepository<EventStatus,Long> {
}
