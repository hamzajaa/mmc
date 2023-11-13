package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventTypeRepositoery extends JpaRepository<EventType,Long> {
}
