package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.service.ProductDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductDController {

    @Autowired
    private ProductDService productDService;

    @GetMapping("/all")
    public List<ProductDTO> getAll() {
        return productDService.getAll();
    }

    public Optional<ProductDTO> getProductD(int productId) {
        return productDService.getProductD(productId);
    }

    public Optional<List<ProductDTO>> getByCategoryD(int categoryId) {
        return productDService.getByCategoryD(categoryId);
    }

    public ProductDTO save(ProductDTO productD) {
        return productDService.save(productD);
    }

    public boolean delete(int productDId) {
        return productDService.delete(productDId);
    }
}
