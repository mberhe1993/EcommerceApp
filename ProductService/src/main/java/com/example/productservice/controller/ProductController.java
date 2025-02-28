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

    @GetMapping("/{productnumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productnumber){
        ProductDTO productDTO = productService.getProduct(productnumber);
        if(productDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(productDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(List.of(productService.getAllProducts()));
    }


    @PutMapping("/update/{productnumber}")
    public ResponseEntity<?> updateProduct(@PathVariable String productnumber, @RequestBody ProductDTO productDTO){
        ProductDTO updatedProduct = productService.updateProduct(productnumber, productDTO);
        if(updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ok(updatedProduct);
    }

    @DeleteMapping("/delete/{productnumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productnumber){
        productService.deleteProduct(productnumber);
        return ok("Product Deleted Successfully");
    }

}
