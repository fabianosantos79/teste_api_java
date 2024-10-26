package com.exemplo.teste.service;

import com.exemplo.teste.domain.Product;
import com.exemplo.teste.dto.RequestProductoDTO;
import com.exemplo.teste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void saveProduct(RequestProductoDTO data){
        Product product = new Product(data);
        productRepository.save(product);
    }
}
