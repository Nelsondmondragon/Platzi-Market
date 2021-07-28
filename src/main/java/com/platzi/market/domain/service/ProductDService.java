package com.platzi.market.domain.service;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.domain.repository.ProductDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDService {

    @Autowired
    private ProductDRepository productDRepository;

    public List<ProductDto> getAll() {
        return productDRepository.getAll();
    }

    public Optional<ProductDto> getProductD(int productDId) {
        return productDRepository.getProductD(productDId);
    }

    public Optional<List<ProductDto>> getByCategoryD(int categoryDId) {
        return productDRepository.getByCategoryD(categoryDId);
    }

    public ProductDto save(ProductDto productD) {
        return productDRepository.save(productD);
    }

    public boolean delete(int productDId) {
        return getProductD(productDId).map(productD -> {
            productDRepository.delete(productDId);
            return true;
        }).orElse(false);
    }
}
