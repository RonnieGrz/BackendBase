package com.example.backendbase.services.interfaces;

import com.example.backendbase.models.UserFinanciera;

import java.util.List;

public interface IuserFinancieraService {

    void createUserFinanciera();

    List<UserFinanciera> getAllUsersFinanciera();

    void updateUserFinanciera();

}
