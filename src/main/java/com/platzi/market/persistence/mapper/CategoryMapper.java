package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.CategoryD;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "idCategoryDTO"),
            @Mapping(source = "description", target = "descriptionDTO"),
            @Mapping(source = "status", target = "activeDTO")
    })
    CategoryD toCategoryD(Category category);


    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryD categoryD);
}
