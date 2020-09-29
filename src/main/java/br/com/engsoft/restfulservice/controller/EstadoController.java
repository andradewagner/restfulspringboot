/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice.controller;

import br.com.engsoft.restfulservice.dao.interfaces.EstadoRepository;
import br.com.engsoft.restfulservice.model.Estado;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tec-zoop
 */
@RestController
@RequestMapping({"/api/estados"})
@CrossOrigin(origins = "http://localhost:8000")
public class EstadoController {
    private EstadoRepository repository;

    EstadoController(EstadoRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id) {
        return repository.findById(id).map(response -> ResponseEntity.ok().body(response))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Estado create(@RequestBody Estado estado) {
        return repository.save(estado);
    }
    
    @PutMapping(value = {"/{id}"})
    public ResponseEntity update(@PathVariable("id") Long id, Estado estado) {
        return repository.findById(id).map(record -> {
            record.setSigla(estado.getSigla());
            record.setNome(estado.getNome());
            
            Estado updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
