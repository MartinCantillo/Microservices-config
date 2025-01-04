package com.martin.springcloud.msvc.products.msvcproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.springcloud.msvc.products.msvcproducts.entities.Product;
import com.martin.springcloud.msvc.products.msvcproducts.repositories.ProductRepository;



@Service
public class ProductServcieImpl implements ProductService {


    private final  ProductRepository productRepository;
    private final Environment environment;

    public ProductServcieImpl(ProductRepository productR, Environment env){
        this.productRepository = productR;
        this.environment=env;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {

        Function<Product,Product> productF= (product) -> {
            product.setPort(Integer.parseInt(this.environment.getProperty("local.server.host")));
            return product;
        };
        return ( ( List<Product>)this.productRepository.findAll()).stream().map(productF).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {

        Function<Product,Product> productF= (product) -> {
            product.setPort(Integer.parseInt(this.environment.getProperty("local.server.host")));
            return product;
        };
        
        return this.productRepository.findById(id).map(productF);
    }
}
