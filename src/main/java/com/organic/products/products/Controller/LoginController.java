package com.organic.products.products.Controller;

import com.organic.products.products.DTO.LoginDto;
import com.organic.products.products.Repository.AdminRepo;
import com.organic.products.products.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class LoginController {

    @Autowired
    public UserRepo userRepo;
    @Autowired
    public AdminRepo adminRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto obj){
        if(obj.getUserType().equals("user")){
            var user = userRepo.findByEmail(obj.getEmail()).orElseThrow(()->new RuntimeException("user not found"));
            if(user.getPassword().equals(obj.getPassword())){
                return new ResponseEntity<>(obj,HttpStatus.OK);
            }else{
                throw new RuntimeException("invalid password");
            }
        } else if (obj.getUserType().equals("admin")) {
            var admin = adminRepo.findByEmail(obj.getEmail()).orElseThrow(()->new RuntimeException("admin not found"));
            if(admin.getPassword().equals(obj.getPassword())){
                return new ResponseEntity<>(obj,HttpStatus.OK);
            }else {
                throw new RuntimeException("invalid password");
            }
        }
        else {
            return new ResponseEntity<>("provide valid userType", HttpStatus.OK);

        }
    }
}
