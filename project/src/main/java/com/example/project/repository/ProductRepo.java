package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.project.model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
    List<Product> findByProductName(String productName);
    List<Product> findByCategory_CategoryName(String categoryName);
}