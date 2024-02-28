package com.organic.products.products.Controller;
import com.organic.products.products.Entity.CartProduct;
import com.organic.products.products.Repository.CartProductRepo;
import com.organic.products.products.Repository.ProdRepo;
import com.organic.products.products.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

public class CartProductController {

    @Autowired
    public CartProductRepo buyProductsRepo;

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public ProdRepo prodRepo;


    @PostMapping("/buyProduct/{pid}/{uid}")
    public ResponseEntity<?> buyProducts(@RequestBody CartProduct obj,@PathVariable Integer pid,@PathVariable Integer uid){
        var user = userRepo.findById(uid).orElseThrow(()->new RuntimeException("user notFound"));
        var product = prodRepo.findById(pid).orElseThrow(()->new RuntimeException("product not found"));
        obj.setProductId(pid);
        obj.setUser(user);
        buyProductsRepo.save(obj);
        return new ResponseEntity<>("added to cart", HttpStatus.OK);
    }

//    @PutMapping("/buyProduct/{cid}")
//    public ResponseEntity<?> bookProduct(@RequestBody CartProduct obj, @PathVariable Integer cid){
//        var product = buyProductsRepo.findById(cid).orElseThrow(()->new RuntimeException("product not found"));
//        product.setStatus(obj.getStatus());
//        buyProductsRepo.save(product);
//        return new ResponseEntity<>("product booked",HttpStatus.OK);
//    }

//    @GetMapping("/getProducts")
//    public ResponseEntity<?> getUser(){
//        var products = buyProductsRepo.findAll();
//        return new ResponseEntity<>(products,HttpStatus.OK);
//    }
//
//    @GetMapping("/getProductsById/{pid}")
//    public ResponseEntity<?> getProductsById(@PathVariable Integer pid){
//        var product = prodRepo.findById(pid).orElseThrow(()->new RuntimeException("product not found"));
//        return new ResponseEntity<>(product,HttpStatus.OK);
//    }

    @DeleteMapping("/deleteProduct/{pid}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer pid){
        var prduct = prodRepo.findById(pid).orElseThrow(()->new RuntimeException("product not found"));
        prodRepo.delete(prduct);
        return new ResponseEntity<>("product deleted",HttpStatus.OK);
    }
}
