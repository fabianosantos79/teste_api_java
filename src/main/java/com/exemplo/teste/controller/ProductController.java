package com.exemplo.teste.controller;

import com.exemplo.teste.dto.RequestProductoDTO;
import com.exemplo.teste.dto.ResponseProductDTO;
import com.exemplo.teste.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ResponseProductDTO>> getAllProduct(){

        List<ResponseProductDTO> responseProductDTO = productService.getAllProduct()
                .stream()
                .map(product -> new ResponseProductDTO(
                        product.getName(),
                        product.getPrice())).
                collect(Collectors.toList());

        return ResponseEntity.ok(responseProductDTO);
    }


    @PostMapping
    @Transactional
    public ResponseEntity saveProduct(@RequestBody RequestProductoDTO data){
        productService.saveProduct(data);
        return ResponseEntity.ok().build();
    }

}
