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
    private String idClient;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
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
