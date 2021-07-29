package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseDto;
import com.platzi.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseDtoItemMapper.class})
public interface PurchaseDtoMapper {

    @Mappings({
            @Mapping(source = "idPurchase",target = "idPurchaseDto"),
            @Mapping(source = "idClient",target = "idClientDto"),
            @Mapping(source = "date",target = "dateDto"),
            @Mapping(source = "paymentMethod",target = "paymentMethodDto"),
            @Mapping(source = "commentary",target = "commentDto"),
            @Mapping(source = "status",target = "stateDto"),
            @Mapping(source = "products",target = "items")
    })
    PurchaseDto toPurchaseD(Purchase purchase);
    List<PurchaseDto> toPurchaseDs(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client",ignore = true)
    Purchase toPurchase(PurchaseDto purchaseDto);
}
