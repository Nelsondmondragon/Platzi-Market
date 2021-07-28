package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "idProductDTO"),
            @Mapping(source = "name", target = "nameDTO"),
            @Mapping(source = "idCategory", target = "idCategoryDTO"),
            @Mapping(source = "priceSale", target = "priceDTO"),
            @Mapping(source = "quantityStock", target = "stockDTO"),
            @Mapping(source = "status", target = "activeDTO"),
            @Mapping(source = "category", target = "categoryDTO")
    })
    ProductDTO toProductD(Product product);

    List<ProductDTO> toProductDs(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductDTO productD);

}
