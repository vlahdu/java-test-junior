/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
public interface ProductService {
    /**
     * @param productDTO this product to be created
     * @return the product created from the database
     */
    ResponseEntity<Product> createProduct(ProductDTO productDTO);

    ResponseEntity<Product> getProduct(Long id);

    ResponseEntity<Product> updateProduct(Long id, Product productDTO);

    ResponseEntity<Product> deleteProduct(Long id);

    ResponseEntity<Page<Product>> getProductsPaginated(int page, int page_size);
}