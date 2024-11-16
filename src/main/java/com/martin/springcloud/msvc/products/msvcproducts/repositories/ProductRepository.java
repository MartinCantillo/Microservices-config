package com.martin.springcloud.msvc.products.msvcproducts.repositories;

import com.martin.springcloud.msvc.products.msvcproducts.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
