/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tec-zoop
 */
@Repository
public interface PaisRepositoy extends JpaRepository<br.com.engsoft.restfulservice.model.Pais, Long>{
    
}
