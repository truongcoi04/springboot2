package com.vti.rw41.service;

import com.vti.rw41.Entity.Product;
import com.vti.rw41.Repository.ProductRepository;
import com.vti.rw41.dto.ProductDto;
import com.vti.rw41.dto.ProductRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceIml implements ProductService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
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
            productRepository.save(product);
        });
        return oldProduct;
    }

    @Override
    public Page<ProductDto> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(product -> {
                    ProductDto dto = new ProductDto();
                    BeanUtils.copyProperties(product, dto);

                   if (product.getCategory() != null){
                       dto.setCategory(product.getCategory().getName());
                   }
                    return dto;
                });
    }
}
