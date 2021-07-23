package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @Column(name = "id")
    private Integer idClient;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surName;

    @Column(name = "celular")
    private Long phoneNumber;

    @Column(name = "direccion")
    private String direction;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;
}
