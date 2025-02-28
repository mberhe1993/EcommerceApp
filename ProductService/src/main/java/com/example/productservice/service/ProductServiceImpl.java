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
    public ProductDTO getProduct(String productnumber) {
        Optional<Product> productOptional = productRepository.findByproductnumber(productnumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a productnumber: {}", productnumber);
                throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productnumber: " + productnumber);
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
    public ProductDTO updateProduct(String productnumber, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findByproductnumber(productnumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a productnumber That you need to update: {}", productnumber);
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productnumber: " + productnumber);
        }
        Product product = productOptional.get();
        product.setproductnumber(productDTO.getproductnumber());
        product.setName(productDTO.getName());
        product.setsupplierPhone(productDTO.getsupplierPhone());
        product.setprice(productDTO.getprice());
        product.setdescription(productDTO.getdescription());
        product.setsupplierName(productDTO.getsupplierName());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(String productnumber) {
        Optional<Product> productOptional = productRepository.findByproductnumber(productnumber);
        if(productOptional.isEmpty()){
            log.info("Product Not Found for a productnumber That you need to delete: {}", productnumber);
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found for a productnumber: " + productnumber);
        }
        productRepository.delete(productOptional.get());
    }

}
