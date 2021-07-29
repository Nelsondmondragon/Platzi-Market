package com.platzi.market.persistence;

import com.platzi.market.domain.PurchaseDto;
import com.platzi.market.domain.repository.PurchaseDRepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.entity.Purchase;
import com.platzi.market.persistence.mapper.PurchaseDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryP implements PurchaseDRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseDtoMapper mapper;

    @Override
    public List<PurchaseDto> getAll() {
        return mapper.toPurchaseDs((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDto>> getByClient(String idClient) {
        return purchaseCrudRepository.findByIdClient(idClient)
                .map(purchases -> mapper.toPurchaseDs(purchases));
    }

    @Override
    public PurchaseDto save(PurchaseDto purchaseDto) {
        Purchase purchase= mapper.toPurchase(purchaseDto);
        purchase.getProducts().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchase));
        return mapper.toPurchaseD(purchaseCrudRepository.save(purchase));
    }
}
