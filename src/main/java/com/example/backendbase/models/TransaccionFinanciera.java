package com.example.backendbase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransaccionFinanciera {
    @Id
    private Long idTransaccion;
}
