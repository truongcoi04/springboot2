package com.vti.rw41.controller;

import com.vti.rw41.Entity.Product;
import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

//    @PostMapping
//    public void receivedRequest(@RequestBody @Valid ProductRequest request) {
//        System.out.println(request);
//    }


    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        log.info("getProductById={}", id);
        return productService.getProductById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product addProduct(@RequestBody @Valid ProductRequest product) {
        return productService.addProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Optional<Product> deleteProduct(@PathVariable Integer id) {
        log.info("getProductById={}", id);
        return productService.deleteProduct(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Optional<Product> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest product) {
        log.info("getProductById={}", id);
        return productService.updateProduct(id, product);
    }
}
