package com.gocarting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplicationClass {

    public static void main(String[] args) {
        // Generate dummy item for our cart
        for (double i = 0.0; i < 250; i++) {
            ItemData.createNewItem(i);
        }

        // Begin running...
        SpringApplication.run(MainApplicationClass.class, args);
    }
}
