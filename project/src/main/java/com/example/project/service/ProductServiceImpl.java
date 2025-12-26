package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product addProduct(Product product){
        return productRepo.save(product);
    }
    @Override
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    @Override
    public Product getProductById(Long id){
        return productRepo.findById(id).orElse(null);
    }
    @Override
    public Product updateProduct(Long id, Product product){
        if(productRepo.existsById(id)){
            product.setProductId(id);
            return productRepo.save(product);
        }
        return null;
    }
    @Override
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
    @Override
    public List<Product> getProductsByCategoryName(String categoryName){
        return productRepo.findByCategory_CategoryName(categoryName);
    }
    @Override
    public List<Product> getProductsByName(String name){
        return productRepo.findByProductName(name);
    }
    @Override
    public Page<Product> getProductsWithPagination(int offset, int pageSize, String field){
        return productRepo.findAll(PageRequest.of(offset,pageSize,Sort.by(field)));
    }
}