package com.java.test.junior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketplaceApplication {
    public static void main(String[] args) {
        // initializare context Spring app
        SpringApplication.run(MarketplaceApplication.class, args);
    }
}

// preluarea bean ProductService din context
/* ProductService productService = context.getBean(ProductService.class);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Test Product");
        productDTO.setPrice(19.99);
        productDTO.setDescription("This is a test product");

        Product createdProduct = productService.createProduct(productDTO);

        System.out.println("Created Product:");
        System.out.println("ID: " + createdProduct.getId());
        System.out.println("Name: " + createdProduct.getName());
        System.out.println("Price: " + createdProduct.getPrice());
        System.out.println("Description: " + createdProduct.getDescription());*/