package org.sid.ecom.web;

import org.sid.ecom.enteties.Product;
import org.sid.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path="/product")
    public List<Product> productList()
    {
        return productRepository.findAll();

    }

    @GetMapping(path ="/products/{id}")
    public Product getProducts(@PathVariable (name ="id") String id) // @PathVariable lie entre le id path et id parametre
    {
        return productRepository.findById(id).get();

    }

    @PostMapping(path = "/products")
    public Product saveProduct(@RequestBody Product product)
    {
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @PostMapping(path = "/products/{id}")
    public Product updatePriduct(@RequestBody Product product, @PathVariable String id)
    {
        product.setId(id);

        return productRepository.save(product);
    }

    @DeleteMapping(path = "/products/{id}")
    public void deletePriduct( @PathVariable String id)
    {

        productRepository.deleteById(id);
    }
}
