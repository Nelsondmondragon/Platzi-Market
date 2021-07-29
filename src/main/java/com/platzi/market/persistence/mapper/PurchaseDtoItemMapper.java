package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseDtoItem;
import com.platzi.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductDtoMapper.class})
public interface PurchaseDtoItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productIdDto")
            , @Mapping(source = "cant", target = "quantity"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseDtoItem toPurchaseDtoItem(PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseDtoItem purchaseDtoItem);
}
