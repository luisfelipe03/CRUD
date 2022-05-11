package br.com.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<contatos> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public contatos create(@RequestBody contatos contato) {
        return repository.save(contato);
    }

    @PutMapping(value="path/{id}")
    public ResponseEntity<contatos> update(@PathVariable("id") Long id, @RequestBody contatos contato) {
        return repository.findById(id)
           .map(record -> {
               record.setNome(contato.getNome());
               record.setEmail(contato.getEmail());
               record.setNumero(contato.getNumero());
               contatos updated = repository.save(record);
               return ResponseEntity.ok().body(updated);
           }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return repository.findById(id)
               .map(record -> {
                   repository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());

            }
}
