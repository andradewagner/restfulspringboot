/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engsoft.restfulservice;

import br.com.engsoft.restfulservice.dao.interfaces.PessoaRepository;
import br.com.engsoft.restfulservice.model.Endereco;
import br.com.engsoft.restfulservice.model.Pessoa;
import java.util.stream.LongStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author tec-zoop
 */
@SpringBootApplication
public class RestfulServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RestfulServiceApplication.class, args);
    }
    
//    @Bean
//    CommandLineRunner init(PessoaRepository repository) {
//        return args -> {
//            repository.deleteAll();
//            LongStream.range(1, 11).mapToObj(i -> {
//                Endereco e = new Endereco();
//                e.setCep("22222-000");
//                e.setComplemento("Loja 1");
//                e.setLogradouro("Rua do sobe desce");
//                e.setNumero(0);
//                
//                Pessoa p = new Pessoa();
//                p.setCpf("12345678901");
//                p.setNome("Wagner Andrade");
//                p.setData_de_nascimento("10/08/1978");
//                p.setEndereco_idendereco(e);
//                return p;
//            }).map(v -> repository.save(v))
//                    .forEach(System.out::println);
//        };
//    }
}