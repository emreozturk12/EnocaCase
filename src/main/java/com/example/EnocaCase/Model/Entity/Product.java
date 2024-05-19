package com.example.EnocaCase.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends Base {

    private String productName;

    @Column(nullable = false)
    private Integer stockNumber;

    private Double productPrice;
}
