/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice.controller;

import br.com.engsoft.restfulservice.dao.interfaces.PessoaRepository;
import br.com.engsoft.restfulservice.model.Pessoa;
import java.util.List;
import org.springframework.http.ResponseEntity;
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
@RequestMapping({"/pessoa"})
public class PessoaController {
    private PessoaRepository repository;
    
    PessoaController(PessoaRepository pr) {
        this.repository = pr;
    }
    
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
        return repository.findById(id).map(record -> {
            record.setCpf(pessoa.getCpf());
            record.setNome(pessoa.getNome());
            record.setData_de_nascimento(pessoa.getData_de_nascimento());
            
            Pessoa updated = repository.save(record);
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
