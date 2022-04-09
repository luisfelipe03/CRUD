package br.com.crud.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
public class contatos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty@NotNull
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 150, message = "O nome não pode ser nulo, no minimo 3 e no maximo 150 caracteres")
    private String nome;

    @Email(message = "Esse Email não é valido")
    @Column(nullable = false, length = 130, unique = true)
    private String email;

    @Column(nullable = false, length = 11)
    private String numero;
    
    @Column(nullable = false)
    @Min(value = 6, message = "Você tem que ter no minimo 6 anos")
    @Max(value = 119, message = "Procure o guinness book porque você bateu o record de pessoa mais velha do mundo, idade maxima 119 anos")
    private int idade;
}
