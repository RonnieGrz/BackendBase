package com.example.backendbase.repositories;

import com.example.backendbase.models.UserFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFinancieraRepository extends JpaRepository<UserFinanciera, Long> {

    @Query(value = "select u from UserFinanciera u where u.numDocumento = ?1")
    UserFinanciera userFinancieraExists(long cedula);
}

