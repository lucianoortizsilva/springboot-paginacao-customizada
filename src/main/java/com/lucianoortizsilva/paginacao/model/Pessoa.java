package com.lucianoortizsilva.paginacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 4517092027019958511L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

}