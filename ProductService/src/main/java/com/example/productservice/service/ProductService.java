package com.example.productservice.service;

import com.example.productservice.DTO.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProduct(String customerNumber);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(String customerNumber, ProductDTO productDTO);

    void deleteProduct(String customerNumber);
}
