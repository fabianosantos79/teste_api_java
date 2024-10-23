package com.exemplo.teste.controller;

import com.exemplo.teste.domain.Product;
import com.exemplo.teste.dto.RequestProductDTO;
import com.exemplo.teste.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<RequestProductDTO>> getAllProduct(){

        List<RequestProductDTO> requestProductDTO = productService.getAllProduct()
                .stream()
                .map(product -> new RequestProductDTO(
                        product.getName(),
                        product.getPrice())).
                collect(Collectors.toList());

        return new ResponseEntity<>(requestProductDTO, HttpStatus.OK);
    }
}
