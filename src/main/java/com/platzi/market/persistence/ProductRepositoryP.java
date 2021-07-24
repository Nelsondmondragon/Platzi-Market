package com.platzi.market.persistence;

import com.platzi.market.domain.ProductD;
import com.platzi.market.domain.repository.ProductDRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryP implements ProductDRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductD> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductDs(products);
    }

    @Override
    public Optional<List<ProductD>> getByCategoryD(int categoryId) {
        List<Product> products = productCrudRepository.finByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductDs(products));
    }

    @Override
    public Optional<List<ProductD>> getScarceProductDs(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByQuantityStockLessThanAndStatus(quantity, true);
        return products.map(products1 -> mapper.toProductDs(products1));
    }

    @Override
    public Optional<ProductD> getProductD(int productId) {

        return productCrudRepository.findById(productId).map(product -> mapper.toProductD(product));
    }

    @Override
    public ProductD save(ProductD productD) {
        Product product = mapper.toProduct(productD);
        return mapper.toProductD(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
