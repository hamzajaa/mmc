package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.entities.Category;

public class CategoryDTOConverter {

    public static Category categoryDtoToCategory(CategoryDTO categoryDTO) {
        Category category = new Category() ;
        category.setId(categoryDTO.getId());
        category.setLabel(categoryDTO.getLabel());
        return category ;
    }

    public static CategoryDTO categoryToCategoryDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO() ;
        categoryDTO.setId(category.getId());
        categoryDTO.setLabel(category.getLabel());
        return categoryDTO;
    }


}
