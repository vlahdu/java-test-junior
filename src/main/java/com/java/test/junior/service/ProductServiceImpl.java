/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductDTO;
import org.springframework.stereotype.Service;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@Service
public class ProductServiceImpl implements ProductService {
    /**
     * @param productDTO this product to be created
     * @return the product created from the database
     */
    @Override
    public Product createProduct(ProductDTO productDTO) {
        return null;
    }
}