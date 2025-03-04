package com.example.productservice.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder(toBuilder = true)
public class ProductDTO {

    private  String productNumber;
    private String  name;
    private String supplierPhone;
    private Double price;
    private String description;
    private String supplierName;

}
