package com.lucianoortizsilva.paginacao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucianoortizsilva.paginacao.model.Pessoa;
import com.lucianoortizsilva.paginacao.repository.PessoaRepository;

@Configuration
public class DataBaseConfig {

	@Autowired
	private PessoaRepository repository;

	@Bean
	public void init() {
		this.repository.save(new Pessoa("Adriano"));
		this.repository.save(new Pessoa("Bruna"));
		this.repository.save(new Pessoa("Carlos"));
		this.repository.save(new Pessoa("Daniela"));
		this.repository.save(new Pessoa("Elias"));
		this.repository.save(new Pessoa("Fabiana"));
		this.repository.save(new Pessoa("Glenio"));
		this.repository.save(new Pessoa("Heitor"));
		this.repository.save(new Pessoa("Ingrid"));
		this.repository.save(new Pessoa("Juliana"));
		this.repository.save(new Pessoa("kenya"));
		this.repository.save(new Pessoa("Luciano"));
		this.repository.save(new Pessoa("Marcos"));
		this.repository.save(new Pessoa("Noé"));
		this.repository.save(new Pessoa("Olivia"));
		this.repository.save(new Pessoa("Paula"));
		this.repository.save(new Pessoa("Rafaela"));
		this.repository.save(new Pessoa("Sirlei"));
		this.repository.save(new Pessoa("Thiago"));
		this.repository.save(new Pessoa("Vânia"));
		
		
	}

}