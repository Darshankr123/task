package com.organic.products.products.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prodName;
    private String prodPrice;
    private String prodQuantity;
    private String prodCategory;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String prodImage;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String prodDescription;

}
