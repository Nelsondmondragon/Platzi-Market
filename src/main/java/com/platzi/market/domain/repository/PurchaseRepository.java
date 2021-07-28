package com.platzi.market.domain.repository;

import com.platzi.market.domain.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDto> getAll();
    Optional<List<PurchaseDto>> getByClient(String idClient);
    PurchaseDto save(PurchaseDto purchaseDto);
}
