package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductDRepository {
    List<ProductDTO> getAll();

    Optional<List<ProductDTO>> getByCategoryD(int categoryId);

    Optional<List<ProductDTO>> getScarceProductDs(int quantity);

    Optional<ProductDTO> getProductD(int productId);

    ProductDTO save(ProductDTO product);

    void delete(int productId);
}
