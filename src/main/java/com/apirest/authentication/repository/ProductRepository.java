package com.apirest.authentication.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.authentication.models.Product;

public interface ProductRepository extends JpaRepository<Product,UUID> {
    
}
