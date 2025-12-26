package com.example.project.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.example.project.model.Product;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getProductsByCategoryName(String categoryName);
    List<Product> getProductsByName(String name);
    Page<Product> getProductsWithPagination(int offset, int pageSize, String field);
}