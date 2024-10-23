package com.exemplo.teste.controller;

import com.exemplo.teste.domain.Product;
import com.exemplo.teste.dto.RequestProductDTO;
import com.exemplo.teste.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/products", produces = {"application/json"})
@Tag(name= "open-api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Busca no banco de dados todos os produtos com nome e preço", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
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
