/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author tec-zoop
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpessoa;
    
    private String cpf;
    private String nome;
    private String data_de_nascimento;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_idendereco", referencedColumnName = "idendereco", insertable = true, updatable = true)
    private Endereco endereco_idendereco;
}