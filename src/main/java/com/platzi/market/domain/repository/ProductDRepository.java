package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductDRepository {
    List<ProductDto> getAll();

    Optional<List<ProductDto>> getByCategoryD(int categoryId);

    Optional<List<ProductDto>> getScarceProductDs(int quantity);

    Optional<ProductDto> getProductD(int productId);

    ProductDto save(ProductDto product);

    void delete(int productId);
}
