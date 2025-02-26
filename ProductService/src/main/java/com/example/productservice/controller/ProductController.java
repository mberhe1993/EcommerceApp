package com.example.productservice.controller;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        return ok(productService.addProduct(productDTO));
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String customerNumber){
        ProductDTO productDTO = productService.getProduct(customerNumber);
        if(productDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(productDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(List.of(productService.getAllProducts()));
    }


    @PutMapping("/update/{customerNumber}")
    public ResponseEntity<?> updateProduct(@PathVariable String customerNumber, @RequestBody ProductDTO productDTO){
        ProductDTO updatedProduct = productService.updateProduct(customerNumber, productDTO);
        if(updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(updatedProduct);
    }

}
