package com.organic.products.products.Repository;

import com.organic.products.products.Entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepo extends JpaRepository<CartProduct,Integer> {
}
