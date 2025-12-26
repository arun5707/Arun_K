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

import com.example.project.model.Product;
import com.example.project.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product createdProduct = productService.addProduct(product);
        if(createdProduct!=null){
            return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedproduct = productService.updateProduct(id, product);
        if(updatedproduct!=null){
            return new ResponseEntity<>(updatedproduct,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id){
        Product product = productService.getProductById(id);
        if(product!=null){
            productService.deleteProduct(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String categoryName){
        List<Product> products = productService.getProductsByCategoryName(categoryName);
        if(products.isEmpty()){
            return new ResponseEntity<>(products,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getProductsByName(@PathVariable String name){
        List<Product> products = productService.getProductsByName(name);
        if(products.isEmpty()){
            return new ResponseEntity<>("No products found with name: "+ name,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/page/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
        Page<Product> products=productService.getProductsWithPagination(offset, pagesize, field);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}