package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartnerRepository extends JpaRepository<Partner, Long> {
}
