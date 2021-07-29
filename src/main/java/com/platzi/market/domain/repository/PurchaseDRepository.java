package com.platzi.market.domain.repository;

import com.platzi.market.domain.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseDRepository {
    List<PurchaseDto> getAll();
    Optional<List<PurchaseDto>> getByClient(String idClient);
    PurchaseDto save(PurchaseDto purchaseDto);
}
