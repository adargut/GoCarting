package com.gocarting.config;

import com.gocarting.item.ItemRepository;
import com.gocarting.item.MockItemRepository;
import com.gocarting.service.CartServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CartServiceImpl.class)
public class Config {
    @Bean
    // Inject item repository dependency to cart service
    public ItemRepository getRepository() {
        return new MockItemRepository();
    }
}
