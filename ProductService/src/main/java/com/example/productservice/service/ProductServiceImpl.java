package com.example.productservice.service;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    private final ProductMapper productMapper;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Product saveProduct = productRepository.save(product);
        return productMapper.toDto(saveProduct);
    }

    @Override
    public ProductDTO getProduct(String customerNumber) {
        Optional<Product> productOptional = productRepository.findByCustomerNumber(customerNumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a customerNumber: {}", customerNumber);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found for a customerNumber: " + customerNumber);
            }
            Product product = productOptional.get();

            ProductDTO productDTO = productMapper.toDto(product);
           log.info("Mapped ProductDTO: {}", productDTO);
            return productDTO;
        }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            log.info("No Products Found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Products Found");
        }
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }


}
