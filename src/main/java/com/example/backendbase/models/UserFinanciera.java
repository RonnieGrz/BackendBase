package com.example.backendbase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "usersFinanciera")
@NoArgsConstructor
@AllArgsConstructor
public class UserFinanciera {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tipoDocumento;

    @Column
    private Long numDocumento;

    @Column
    private String nombreUser;

    @Column
    private String apellidoUser;

    @Column
    private String emailUser;

    @Column
    private LocalDate fechaNacimientoUser;

    @Column
    private LocalDateTime fechaCreacionUser;

    @Column
    private LocalDateTime fechaModificacionUser;



}
