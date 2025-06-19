package com.technolab.academicsvc.controllers;


import com.technolab.academicsvc.models.Domaine;
import com.technolab.academicsvc.services.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("academic/domaine")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @PostMapping
    public Domaine create(@RequestBody Domaine o){
        System.out.println(o.getNom());
        return domaineService.create(o);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody Domaine o){
        domaineService.update(id,o);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable long id){
        return domaineService.delete(id);
    }
    @GetMapping("/{id}")
    public Domaine get(@PathVariable long id){
        return domaineService.findById(id);
     }
    @GetMapping
    public List<Domaine> find(){
        return  domaineService.finAll();
    }

    @GetMapping("search/{nom}")
    public ResponseEntity search(@PathVariable String nom) {
        return ResponseEntity.ok(domaineService.search(nom));
    }


}
