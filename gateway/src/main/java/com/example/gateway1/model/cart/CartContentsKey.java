package com.example.gateway1.model.cart;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CartContentsKey implements Serializable {

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "part_id")
    private Long partId;
}
