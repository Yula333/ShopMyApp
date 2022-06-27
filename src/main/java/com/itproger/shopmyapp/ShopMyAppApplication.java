package com.itproger.shopmyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ShopMyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopMyAppApplication.class, args);
    }
}
