package com.example.backendbase.models;

import jakarta.persistence.*;

@Entity
public class productoFinanciera {

    @Id
    @Column(name = "numeroCuenta")
    private Long numCuenta;

    @Column
    private int tipoCuenta;

    @Column
    private String detalleCuenta;

    @Column
    private Long idUserFinanciera;

}
