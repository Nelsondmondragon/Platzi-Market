package com.platzi.market.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseDto {

    private int idPurchaseDto;
    private String idClientDto;
    private LocalDateTime dateDto;
    private String paymentMethodDto;
    private String commentDto;
    private String stateDto;
    private List<PurchaseDtoItem> items;

}
