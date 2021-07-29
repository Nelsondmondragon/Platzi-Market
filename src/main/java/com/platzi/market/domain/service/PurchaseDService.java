package com.platzi.market.domain.service;

import com.platzi.market.domain.PurchaseDto;
import com.platzi.market.domain.repository.PurchaseDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseDService {

    @Autowired
    private PurchaseDRepository purchaseDRepository;

    public List<PurchaseDto> getAll() {
        return purchaseDRepository.getAll();
    }

    public Optional<List<PurchaseDto>> getByIdClient(String idClientDto) {
        return purchaseDRepository.getByClient(idClientDto);
    }

    public PurchaseDto save(PurchaseDto purchaseDto) {
        return purchaseDRepository.save(purchaseDto);
    }
}
