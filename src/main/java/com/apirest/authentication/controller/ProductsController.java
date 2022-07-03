package com.apirest.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.authentication.models.Product;
import com.apirest.authentication.service.ListProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ListProductService listProductService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Product> list() {
        return listProductService.listAll();
    }
}
