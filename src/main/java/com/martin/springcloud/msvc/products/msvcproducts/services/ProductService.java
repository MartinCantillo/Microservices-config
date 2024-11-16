package com.martin.springcloud.msvc.products.msvcproducts.services;

import com.martin.springcloud.msvc.products.msvcproducts.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);

}
