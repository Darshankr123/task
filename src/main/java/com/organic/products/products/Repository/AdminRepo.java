package com.organic.products.products.Repository;

import com.organic.products.products.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

    Optional<Admin> findByEmail(String email);
}
