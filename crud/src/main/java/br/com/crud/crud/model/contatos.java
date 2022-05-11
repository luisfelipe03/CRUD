package br.com.crud.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class contatos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 150, message = "O nome não pode ser nulo, no minimo 3 e no maximo 150 caracteres")
    private String nome;

    @Email(message = "Esse Email não é valido")
    @Size(min = 11, max = 255)
    @NotNull
    private String email;

	@Size(min = 11, max = 11)
    @NotNull
    private String numero;
    
    @NotNull
    @Min(value = 6, message = "Você tem que ter no minimo 6 anos")
    @Max(value = 119, message = "Procure o guinness book porque você bateu o record de pessoa mais velha do mundo, idade maxima 119 anos")
    private int idade;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
