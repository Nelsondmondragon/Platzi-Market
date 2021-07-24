package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductD;

import java.util.List;
import java.util.Optional;

public interface ProductDRepository {
    List<ProductD> getAll();

    Optional<List<ProductD>> getByCategoryD(int categoryId);

    Optional<List<ProductD>> getScarceProductDs(int quantity);

    Optional<ProductD> getProductD(int productId);

    ProductD save(ProductD product);

    void delete(int productId);
}
