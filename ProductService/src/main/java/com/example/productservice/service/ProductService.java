package com.example.productservice.service;

import com.example.productservice.DTO.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProduct(String productNumber);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(String productNumber, ProductDTO productDTO);

    void deleteProduct(String productNumber);
}
