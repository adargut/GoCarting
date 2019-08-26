package com.gocarting;

import com.gocarting.service.CartService;
import com.gocarting.service.CartServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoCartingApplication {

    public static void main(String[] args) {
        // Generate mock DB repository for our cart
        CartService cartService = new CartServiceImpl();

        // Begin running...
        SpringApplication.run(GoCartingApplication.class, args);
    }
}
