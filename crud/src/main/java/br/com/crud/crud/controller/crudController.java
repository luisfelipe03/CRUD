package br.com.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.crud.model.contatos;
import br.com.crud.crud.repository.contatoRepository;

@RestController
@RequestMapping(value = "/contatos")
public class crudController {

    @Autowired
    private contatoRepository repository;

    crudController(contatoRepository contatoRepository) {
        this.repository = contatoRepository;
    }

    @GetMapping
    public List<contatos> listar() {
        return repository.findAll();
    }

}
