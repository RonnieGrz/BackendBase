package com.example.backendbase.services;

import com.example.backendbase.models.UserFinanciera;
import com.example.backendbase.services.interfaces.IuserFinancieraService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userFinancieraService implements IuserFinancieraService {

    @Override
    public void createUserFinanciera() {

    }

    @Override
    public List<UserFinanciera> getAllUsersFinanciera() {
        List<UserFinanciera> usuariosFinanciera = new ArrayList<UserFinanciera>();
        return usuariosFinanciera;
    }

    @Override
    public void updateUserFinanciera() {

    }
}
