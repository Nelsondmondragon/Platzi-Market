package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.ProductD;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "priceSale", target = "price"),
            @Mapping(source = "quantityStock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductD toProductD(Product product);

    List<ProductD> toProductDs(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductD productD);

}
