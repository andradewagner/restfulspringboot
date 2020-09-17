/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idendereco;
    
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_idestado", referencedColumnName = "idestado", insertable = false, updatable = false)
    private Estado estado_idestado;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_idcidade", referencedColumnName = "idcidade", insertable = false, updatable = false)
    private Cidade cidade_idcidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_idpais", referencedColumnName = "idpais", insertable = false, updatable = false)
    private Pais pais_idpais;
}
