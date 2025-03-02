package com.example.productservice.mapper;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.model.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    public  ProductDTO toDto(Product product){
        if(product == null){
            return null;
        }
        return ProductDTO.builder()
                .productNumber(product.getProductNumber())
                .name(product.getName())
                .supplierPhone(product.getSupplierPhone())
                .price(product.getPrice())
                .description(product.getDescription())
                .supplierName(product.getSupplierName())
                .build();

    }

    public  Product toProduct(ProductDTO productDTO){
        if(productDTO == null){
            return null;
        }
          return Product.builder()
                .productNumber(productDTO.getProductNumber())
                .name(productDTO.getName())
                .supplierPhone(productDTO.getSupplierPhone())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .supplierName(productDTO.getSupplierName())
                .build();

    }
}
