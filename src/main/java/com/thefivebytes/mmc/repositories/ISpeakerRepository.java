package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpeakerRepository extends JpaRepository<Speaker, Long> {
}
