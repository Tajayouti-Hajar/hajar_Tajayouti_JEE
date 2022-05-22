package org.sid.ecom;

import org.sid.ecom.enteties.Product;
import org.sid.ecom.repositories.CategoryRepository;
import org.sid.ecom.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }







 /*public CommandLineRunner start(ProductRepository productRepository) {
        return arg ->
        {
            Stream.of("Coputer", "tv", "SmartPhone").forEach(name ->
            {
                productRepository.save(
                        new Product(UUID.randomUUID().toString(), name, Math.random() * 8000, Math.random() * 100)
                );

            });
        };
    }
 public CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository)
 {

 }*/

}


