package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryDtoMapper.class})
public interface ProductDtoMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "idProductDto"),
            @Mapping(source = "name", target = "nameDto"),
            @Mapping(source = "idCategory", target = "idCategoryDto"),
            @Mapping(source = "priceSale", target = "priceDto"),
            @Mapping(source = "quantityStock", target = "stockDto"),
            @Mapping(source = "status", target = "activeDto"),
            @Mapping(source = "category", target = "categoryDto")
    })
    ProductDto toProductD(Product product);
    List<ProductDto> toProductDs(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductDto productD);

}
