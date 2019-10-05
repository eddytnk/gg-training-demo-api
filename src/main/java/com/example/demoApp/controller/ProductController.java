package com.example.demoApp.controller;

import com.example.demoApp.domain.Product;
import com.example.demoApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Edward Tanko <br/>
 * Date: 8/28/19 5:46 AM <br/>
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@RequestParam("productId") Long productId){
        productService.deleteProduct(productId);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@RequestParam("productId") Long productId){
        //get product
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity<String> getWelcomeMessage(){
        return ResponseEntity.ok(productService.welcomeMessage());
    }
}
