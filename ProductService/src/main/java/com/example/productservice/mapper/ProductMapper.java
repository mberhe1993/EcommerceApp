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
                dto.setproductnumber(product.getproductnumber());
                dto.setName(product.getName());
                dto.setsupplierPhone(product.getsupplierPhone());
                dto.setprice(product.getprice());
                dto.setdescription(product.getdescription());
                dto.setsupplierName(product.getsupplierName());
                return dto;
    }

    public  Product toProduct(ProductDTO productDTO){
        if(productDTO == null){
            return null;
        }
          Product product  = new Product();
                product.setproductnumber(productDTO.getproductnumber());
                product.setName(productDTO.getName());
                product.setsupplierPhone(productDTO.getsupplierPhone());
                product.setprice(productDTO.getprice());
                product.setdescription(productDTO.getdescription());
                product.setsupplierName(productDTO.getsupplierName());
                return product;

    }
}
