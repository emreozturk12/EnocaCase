package com.example.EnocaCase.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Order extends Base {

    @ManyToOne
    @JoinColumn(name = "customer")
    private Integer customerId;

    private LocalDateTime orderDate;
    private Double orderPrice;
}
