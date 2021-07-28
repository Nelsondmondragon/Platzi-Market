package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.CategoryDto;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "idCategoryDto"),
            @Mapping(source = "description", target = "descriptionDto"),
            @Mapping(source = "status", target = "activeDto")
    })
    CategoryDto toCategoryD(Category category);


    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto categoryDto);
}
