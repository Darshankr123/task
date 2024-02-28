package com.organic.products.products.Controller;

import com.organic.products.products.Entity.User;
import com.organic.products.products.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

public class UserController {

    @Autowired
    public UserRepo userRepo;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody User obj){
        obj.setId((int)(Math.round(Math.random()+1000)));
        userRepo.save(obj);
        return new ResponseEntity<>("signed up", HttpStatus.OK);
    }

    @GetMapping("/getUser/{email}")
    public ResponseEntity<?> getUser(@PathVariable String email){
        var user = userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));
            return new ResponseEntity<>(user,HttpStatus.OK);

    }
}
