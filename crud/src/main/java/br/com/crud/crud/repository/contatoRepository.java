package br.com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.crud.model.contatos;

@Repository
public interface contatoRepository extends JpaRepository<contatos, Long>{

    
}