package com.organic.products.products.Controller;

import com.organic.products.products.Entity.Product;
import com.organic.products.products.Repository.ProdRepo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

public class ProductController {

    @Autowired
    public ProdRepo prodRepo;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product obj){
        prodRepo.save(obj);
        return new ResponseEntity<>("product added", HttpStatus.OK);
    }


    @GetMapping("/getOrganicProds")
    public ResponseEntity<?> getProducts(){
        var products = prodRepo.findAll();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/getProductById/{pid}")
    public ResponseEntity<?> getProductById(@PathVariable Integer pid){
        var product = prodRepo.findById(pid).orElseThrow(()->new RuntimeException("product not found"));
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
