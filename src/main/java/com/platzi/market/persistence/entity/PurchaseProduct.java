package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "compras_productos")
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductPK id;

    @Column(name = "columna")
    private Integer cant;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;
}
