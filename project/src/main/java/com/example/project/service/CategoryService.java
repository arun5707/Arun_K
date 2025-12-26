package com.example.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.project.model.Category;


public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    Page<Category> getAllCategoriesWithPagination(int offset, int pageSize);
}