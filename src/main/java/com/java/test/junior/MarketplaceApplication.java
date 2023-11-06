package com.java.test.junior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.java.test.junior")
public class MarketplaceApplication {
    public static void main(String[] args) {
        // initializare context Spring app
        SpringApplication.run(MarketplaceApplication.class, args);
    }
}
