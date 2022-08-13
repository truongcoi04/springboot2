package com.vti.rw41.service;

import com.vti.rw41.Entity.Product;
import com.vti.rw41.dto.ProductDto;
import com.vti.rw41.dto.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {



   Optional<Product> getProductById(Integer id);

   Product addProduct(ProductRequest product);

   Optional<Product> deleteProduct(Integer id);

   Optional<Product> updateProduct(Integer id, ProductRequest product);


   Page<ProductDto> getAllProduct(Pageable pageable);
}
