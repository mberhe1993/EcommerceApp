package com.example.productservice.service;

import com.example.productservice.DTO.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProduct(String productnumber);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(String productnumber, ProductDTO productDTO);

    void deleteProduct(String productnumber);
}
