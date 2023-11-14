package com.thefivebytes.mmc.controllers;


import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.services.facade.ICategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addNewCategory(categoryDTO).orElseThrow() ;
    }


    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO).orElseThrow();
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }







}
