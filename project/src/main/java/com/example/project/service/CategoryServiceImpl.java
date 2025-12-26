package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.model.Category;
import com.example.project.repository.CategoryRepo;



@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }
    @Override
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }
    @Override
    public Category getCategoryById(Long id){
        return categoryRepo.findById(id).orElse(null);
    }
    @Override
    public Category updateCategory(Long id, Category category){
        if(categoryRepo.existsById(id)){
            category.setCategoryId(id);
            return categoryRepo.save(category);
        }
        return null;
    }
    @Override
    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }
    @Override
    public Page<Category> getAllCategoriesWithPagination(int offset, int pageSize){
        return categoryRepo.findAll(PageRequest.of(offset, pageSize));
    }
}