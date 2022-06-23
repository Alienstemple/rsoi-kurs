package com.example.gateway1.model.order;

import com.example.gateway1.model.part.PartForDisplay;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderForDisplay {
    private Long id;
    private List<PartForDisplay> parts;
    private BigDecimal price;
}
