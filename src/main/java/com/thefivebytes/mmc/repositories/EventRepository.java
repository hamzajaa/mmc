package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
