package com.example.productservice.service;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.utility.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
    public ProductDTO getProduct(String productNumber) {
        Optional<Product> productOptional = productRepository.findByproductNumber(productNumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a productNumber: {}", productNumber);
                throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productNumber: " + productNumber);
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
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "No Products Found");
        }
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(String productNumber, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findByproductNumber(productNumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a productNumber That you need to update: {}", productNumber);
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productNumber: " + productNumber);
        }
        Product product = productOptional.get();
        product.setProductNumber(productDTO.getProductNumber());
        product.setName(productDTO.getName());
        product.setSupplierName(productDTO.getSupplierName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setSupplierName(productDTO.getSupplierName());
        product.setSupplierPhone(productDTO.getSupplierPhone());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(String productNumber) {
        Optional<Product> productOptional = productRepository.findByproductNumber(productNumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a productNumber That you need to delete: {}", productNumber);
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productNumber: " + productNumber);
        }
        productRepository.delete(productOptional.get());
    }

}
