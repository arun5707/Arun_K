package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Category;
import com.example.project.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category>createCategory(@RequestBody Category category)
    {
        if(category==null || category.getCategoryName()==null || category.getCategoryName().trim().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Category createdCategory=categoryService.addCategory(category);
        if(createdCategory!=null){
            return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(category, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories=categoryService.getAllCategories();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Category category=categoryService.getCategoryById(id);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
        Category updated=categoryService.updateCategory(id, category);
        if(updated==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteCategory(@PathVariable Long id){
        Category category=categoryService.getCategoryById(id);
        if(category==null){
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Category>> getAllCategoriesWithPagination(@PathVariable int pageNumber, @PathVariable int pageSize){
        Page<Category> page=categoryService.getAllCategoriesWithPagination(pageNumber, pageSize);
        return new ResponseEntity<>(page,HttpStatus.OK);
    }
}