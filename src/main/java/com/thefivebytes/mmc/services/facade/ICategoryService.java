package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Optional<CategoryDTO> findCategoryById(Long id) ;
    Optional<List<CategoryDTO>> findAllCategories() ;
    Optional<CategoryDTO> addNewCategory(CategoryDTO categoryDTO) ;
    Optional<CategoryDTO> updateCategory(CategoryDTO categoryDTO) ;
    void deleteCategory(Long id);


}
