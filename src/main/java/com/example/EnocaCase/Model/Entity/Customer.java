package com.example.EnocaCase.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends Base {

    String customerName;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "order")
    private List<Integer> orders;



}
