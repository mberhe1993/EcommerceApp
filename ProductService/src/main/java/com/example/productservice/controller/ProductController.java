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

    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productNumber){
        ProductDTO productDTO = productService.getProduct(productNumber);
        if(productDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(productDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(List.of(productService.getAllProducts()));
    }


    @PutMapping("/update/{productNumber}")
    public ResponseEntity<?> updateProduct(@PathVariable String productNumber, @RequestBody ProductDTO productDTO){
        ProductDTO updatedProduct = productService.updateProduct(productNumber, productDTO);
        if(updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(updatedProduct);
    }

    @DeleteMapping("/delete/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productNumber){
        productService.deleteProduct(productNumber);
        return ok("Product Deleted Successfully");
    }

}
