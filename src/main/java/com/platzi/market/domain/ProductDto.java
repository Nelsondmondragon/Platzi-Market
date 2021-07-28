package com.platzi.market.domain;

import lombok.Data;

@Data
public class ProductDto {
    private int idProductDto;
    private String nameDto;
    private int idCategoryDto;
    private double priceDto;
    private int StockDto;
    private boolean activeDto;
    private CategoryDto categoryDto;
}
