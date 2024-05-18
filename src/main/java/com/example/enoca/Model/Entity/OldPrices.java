package com.example.enoca.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class OldPrices extends Base{

    @JoinColumn(table = "Order", referencedColumnName = "id")
    private UUID orderId;

    @JoinColumn(table = "Customer", referencedColumnName = "id")
    private Integer customerId;

    @JoinColumn(table = "Product", referencedColumnName = "id")
    private Integer productId;

    private Double productPrice;
    private Integer productCount;

}
