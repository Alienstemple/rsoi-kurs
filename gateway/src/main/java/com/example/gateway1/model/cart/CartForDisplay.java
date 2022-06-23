package com.example.gateway1.model.cart;

import com.example.gateway1.model.part.PartForDisplay;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartForDisplay {
    List<PartForDisplay> parts;
    BigDecimal finalPrice;
}
