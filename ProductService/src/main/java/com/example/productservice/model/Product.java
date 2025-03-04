package com.example.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@Builder(toBuilder = false)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String productNumber;
    private String name;
    private String supplierPhone;
    private Double price;
    private String description;
    private String supplierName;

}
