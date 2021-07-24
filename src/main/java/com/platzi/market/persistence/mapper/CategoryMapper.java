package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.CategoryD;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")

    })
    CategoryD toCategoryD(Category category);


    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryD categoryD);
}
