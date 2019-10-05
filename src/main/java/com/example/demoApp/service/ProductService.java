package com.example.demoApp.service;

import com.example.demoApp.domain.Product;
import com.example.demoApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Edward Tanko <br/>
 * Date: 8/28/19 5:35 AM <br/>
 */
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    public Product getProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(!productOptional.isPresent()){
            throw new RuntimeException("Product not found.");
        }
        return productOptional.get();
    }
}
