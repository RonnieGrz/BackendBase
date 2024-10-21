package com.example.backendbase.controllers;

import com.example.backendbase.models.UserFinanciera;
import com.example.backendbase.repositories.UserFinancieraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@RestController
public class UserFinancieraController {

    @Autowired
    private UserFinancieraRepository userFinancieraRepository;

    @PostMapping()
    public ResponseEntity createUserFinanciera(@RequestBody UserFinanciera userFinanciera){
        try{
            if(userFinancieraRepository.userFinancieraExists(userFinanciera.getNumDocumento()) != null){
                return ResponseEntity.status(300).body("El cliente ya se encuentra registrado en el sistema");
            }else{
                Period period = Period.between(userFinanciera.getFechaNacimientoUser(), LocalDate.now());
                var edad = period.getYears();
                if(edad < 18 ){
                    return ResponseEntity.status(300).body("No se puede registrar un cliente menor de edad");
                }else{
                    userFinanciera.setFechaCreacionUser(LocalDateTime.now());
                    userFinanciera.setFechaModificacionUser(LocalDateTime.now());
                    userFinancieraRepository.save(userFinanciera);
                    return ResponseEntity.status(200).body("Usuario " + userFinanciera.getNombreUser() + " " + userFinanciera.getApellidoUser() + " creado exitosamente");
                }
            }
        }catch (Exception ex){
           return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/users")
    public List<UserFinanciera> getAllUsersFinanciera() {
        return userFinancieraRepository.findAll();
    }

    @PostMapping("user/{id}")
    public ResponseEntity editUserFinanciera(@PathVariable Long id, @RequestBody UserFinanciera userFinanciera){
        try{
            UserFinanciera updateUserFinanciera = userFinancieraRepository.getReferenceById(id);

            updateUserFinanciera.setNombreUser(userFinanciera.getNombreUser());
            updateUserFinanciera.setEmailUser(userFinanciera.getEmailUser());
            updateUserFinanciera.setApellidoUser(userFinanciera.getApellidoUser());
            updateUserFinanciera.setFechaModificacionUser(LocalDateTime.now());
            updateUserFinanciera.setNombreUser(userFinanciera.getNombreUser());
            userFinancieraRepository.save(updateUserFinanciera);

            return ResponseEntity.status(200).body("Usuario actualizado con exito");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
