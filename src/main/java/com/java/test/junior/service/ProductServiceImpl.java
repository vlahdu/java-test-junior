/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductDTO;
import com.java.test.junior.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * @param productDTO this product to be created
     * @return the product created from the database
     */
    @Override
    public ResponseEntity<Product> createProduct(ProductDTO productDTO) {
        Product existingProduct = productRepository.findByName(productDTO.getName());

        if (existingProduct != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        else {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(LocalDateTime.now());
            product.setUserId(1L);
            productRepository.save(product);

            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
    }

    @Override
    public ResponseEntity<Product> getProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent())
        {
            Product existingProduct = existingProductOptional.get();

            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setUpdatedAt(LocalDateTime.now());
            existingProduct.setUserId(updatedProduct.getUserId());

            productRepository.save(existingProduct);

            return ResponseEntity.ok(existingProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent())
        {
            Product product = productOptional.get();
            productRepository.delete(product);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Page<Product>> getProductsPaginated(int page, int pageSize) {
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<Product> allProducts = productRepository.findAll(pageable);

        if (allProducts.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(allProducts);
    }
}