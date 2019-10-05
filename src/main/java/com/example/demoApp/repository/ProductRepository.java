package com.example.demoApp.repository;

import com.example.demoApp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Edward Tanko <br/>
 * Date: 8/28/19 5:34 AM <br/>
 */
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
