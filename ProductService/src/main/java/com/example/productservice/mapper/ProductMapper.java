package com.example.productservice.mapper;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {

    public  ProductDTO toDto(Product product){
        if(product == null){
            return null;
        }
         ProductDTO dto = new ProductDTO();
                dto.setCustomerNumber(product.getCustomerNumber());
                dto.setName(product.getName());
                dto.setPhone(product.getPhone());
                dto.setEmail(product.getEmail());
                dto.setStreet(product.getStreet());
                dto.setCity(product.getCity());
                dto.setZip(product.getZip());
                return dto;
    }

    public  Product toProduct(ProductDTO productDTO){
        if(productDTO == null){
            return null;
        }
          Product product  = new Product();
                product.setCustomerNumber(productDTO.getCustomerNumber());
                product.setName(productDTO.getName());
                product.setPhone(productDTO.getPhone());
                product.setEmail(productDTO.getEmail());
                product.setStreet(productDTO.getStreet());
                product.setCity(productDTO.getCity());
                product.setZip(productDTO.getZip());
                return product;

    }
}
