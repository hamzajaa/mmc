package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.converters.CategoryDTOConverter;
import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.entities.Category;
import com.thefivebytes.mmc.repositories.ICategoryRepository;
import com.thefivebytes.mmc.services.facade.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryDTO> findCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return Optional.of(CategoryDTOConverter.categoryToCategoryDto(category));
    }

    @Override
    public Optional<List<CategoryDTO>> findAllCategories() {
        List<Category> categories = categoryRepository.findAll() ;
        List<CategoryDTO> categoryDTOS = categories.stream().map(CategoryDTOConverter::categoryToCategoryDto).toList() ;
        return Optional.of(categoryDTOS) ;
    }

    @Override
    public Optional<CategoryDTO> addNewCategory(@RequestBody  CategoryDTO categoryDTO) {
        Category category = CategoryDTOConverter.categoryDtoToCategory(categoryDTO) ;
        return Optional.of(CategoryDTOConverter.categoryToCategoryDto(categoryRepository.save(category)));
    }

    @Override
    public Optional<CategoryDTO> updateCategory(CategoryDTO categoryDTO) {
        if(findCategoryById(categoryDTO.getId()).isPresent()) {
            Category category = CategoryDTOConverter.categoryDtoToCategory(categoryDTO) ;
            return Optional.of(CategoryDTOConverter.categoryToCategoryDto(categoryRepository.save(category)));
        }
        return Optional.empty();
    }

    @Override
    public void deleteCategory(Long id) {
        if(findCategoryById(id).isPresent()){
            categoryRepository.deleteById(id);
        }
    }
}
