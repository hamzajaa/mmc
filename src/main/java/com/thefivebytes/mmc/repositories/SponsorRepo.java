package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepo extends JpaRepository<Sponsor,Long> {
}
