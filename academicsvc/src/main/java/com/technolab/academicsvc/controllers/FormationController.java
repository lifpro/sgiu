package com.technolab.academicsvc.controllers;

import com.technolab.academicsvc.models.Formation;
import com.technolab.academicsvc.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("academic/formation")
public class FormationController {
    @Autowired
    private FormationService formationService;

    @PostMapping
    public Formation create(@RequestBody Formation o){
        return formationService.create(o);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody Formation o){
        formationService.update(id,o);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable long id){
        return formationService.delete(id);
    }
    @GetMapping("/{id}")
    public Formation get(@PathVariable long id){
        return formationService.findById(id);
     }
    @GetMapping
    public List<Formation> find(){
        return  formationService.finAll();
    }

    @GetMapping("search/{nom}")
    public ResponseEntity search(@PathVariable String nom) {
        return ResponseEntity.ok(formationService.search(nom));
    }


}
