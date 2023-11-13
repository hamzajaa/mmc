package com.thefivebytes.mmc.repositories;

import com.thefivebytes.mmc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
