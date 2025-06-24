package com.technolab.registrationsvc.controllers;


import com.technolab.registrationsvc.models.Registration;
import com.technolab.registrationsvc.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registration/inscription")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Registration create(@RequestBody Registration o){
        return registrationService.create(o);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody Registration o){
        registrationService.update(id,o);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable long id){
        return registrationService.delete(id);
    }
    @GetMapping("/{id}")
    public Registration get(@PathVariable long id){
        return registrationService.findById(id);
     }
    @GetMapping
    public List<Registration> find(){
        return  registrationService.finAll();
    }


}
