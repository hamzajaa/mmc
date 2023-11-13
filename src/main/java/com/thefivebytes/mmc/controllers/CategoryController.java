package com.thefivebytes.mmc.controllers;


import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.services.facade.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService ;


    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryDTO findProductById(@PathVariable long id) {
        return categoryService.findCategoryById(id).orElseThrow();
    }

    @GetMapping
    public List<CategoryDTO> findAllCategories() {
        return categoryService.findAllCategories().orElseThrow() ;
    }


    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addNewCategory(categoryDTO).orElseThrow() ;
    }


    @PutMapping
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO).orElseThrow();
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }







}
