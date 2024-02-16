package com.carlos.sbcrud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.sbcrud.entities.User;
import com.carlos.sbcrud.servicies.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping    
    public List<User> list(){
        return service.findAll();
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){
        if(result.hasFieldErrors()){
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }


    private ResponseEntity<?> validation(BindingResult result){
        Map<String,String> errors = new HashMap<>();

        result.getFieldErrors().forEach(e->{
            errors.put(e.getField(),"El campo "+e.getField() +" "+e.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }


}
