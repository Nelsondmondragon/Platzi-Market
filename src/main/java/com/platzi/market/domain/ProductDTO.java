package com.platzi.market.domain;

import lombok.Data;

@Data
public class ProductDTO {
    private int idProductDTO;
    private String nameDTO;
    private int idCategoryDTO;
    private double priceDTO;
    private int StockDTO;
    private boolean activeDTO;
    private CategoryD categoryDTO;
}
