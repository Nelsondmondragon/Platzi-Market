package com.platzi.market.domain;

import lombok.Data;

@Data
public class PurchaseDtoItem {
    private int productIdDto;
    private int quantity;
    private  double total;
    private boolean active;
}
