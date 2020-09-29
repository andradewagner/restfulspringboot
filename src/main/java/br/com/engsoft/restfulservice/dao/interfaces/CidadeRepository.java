/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice.dao.interfaces;

import br.com.engsoft.restfulservice.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tec-zoop
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
}
