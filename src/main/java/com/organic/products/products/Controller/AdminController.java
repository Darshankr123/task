package com.organic.products.products.Controller;

import com.organic.products.products.Entity.Admin;
import com.organic.products.products.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class AdminController {

    @Autowired
    public AdminRepo adminRepo;

    @PostMapping("/admin")
    public ResponseEntity<?> admin(@RequestBody Admin obj){
        adminRepo.save(obj);
        return new ResponseEntity<>("admin", HttpStatus.OK);
    }
}
