package com.organic.products.products.Repository;

import com.organic.products.products.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepo extends JpaRepository<Product,Integer> {
}
