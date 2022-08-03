package com.vti.rw41.service;

import com.vti.rw41.Entity.Product;
import com.vti.rw41.Repository.ProductRepository;
import com.vti.rw41.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIml implements ProductService{

    @Autowired
   ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
product.setPassword(productRequest.getPassword());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> deleteProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(product1 -> productRepository.delete(product1));
        return product;
    }

    @Override
    public Optional<Product> updateProduct(Integer id, ProductRequest productRequest) {
        Optional<Product> oldProduct = productRepository.findById(id);
        oldProduct.ifPresent(product -> {
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setPassword(productRequest.getPassword());
            productRepository.save(product);
        });
        return oldProduct;
    }
}
