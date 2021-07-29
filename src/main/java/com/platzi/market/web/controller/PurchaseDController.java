package com.platzi.market.web.controller;

import com.platzi.market.domain.PurchaseDto;
import com.platzi.market.domain.service.PurchaseDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseDController {

    @Autowired
    private PurchaseDService purchaseDService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDto>> getAll() {
        return new ResponseEntity<>(purchaseDService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<PurchaseDto>> getByIdClient(@PathVariable("idClient") String idClient) {

        return purchaseDService.getByIdClient(idClient)
                .map(purchaseDtos -> new ResponseEntity<>(purchaseDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDto> save(@RequestBody PurchaseDto purchaseDto){
        return new ResponseEntity<>(purchaseDService.save(purchaseDto),HttpStatus.CREATED);
    }
}
