package com.vti.rw41.service;

import com.vti.rw41.Entity.Product;
import com.vti.rw41.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public Optional<Product> deleteProduct(Integer id) {
        return productRepository.deleteProduct(id);
    }

    public Optional<Product> updateProduct(Integer id, Product product) {
        return productRepository.updateProduct(id, product);
    }
}
