package com.example.productservice.service;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


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

    @Override
    public ProductDTO updateProduct(String customerNumber, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findByCustomerNumber(customerNumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a customerNumber That you need to update: {}", customerNumber);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found for a customerNumber: " + customerNumber);
        }
        Product product = productOptional.get();
        product.setCustomerNumber(productDTO.getCustomerNumber());
        product.setName(productDTO.getName());
        product.setPhone(productDTO.getPhone());
        product.setEmail(productDTO.getEmail());
        product.setStreet(productDTO.getStreet());
        product.setCity(productDTO.getCity());
        product.setZip(productDTO.getZip());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(String customerNumber) {
        Optional<Product> productOptional = productRepository.findByCustomerNumber(customerNumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a customerNumber That you need to delete: {}", customerNumber);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found for a customerNumber: " + customerNumber);
        }
        productRepository.delete(productOptional.get());
    }


}
