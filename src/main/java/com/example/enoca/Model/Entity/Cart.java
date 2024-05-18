package com.example.enoca.Model.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart extends Base {

    @OneToOne
    private Integer customerId;

    private Double cartPrice;

    @OneToMany(mappedBy = "product")
    private Integer productId;

    private Integer productCount;
}
