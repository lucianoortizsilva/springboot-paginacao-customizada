package com.lucianoortizsilva.paginacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucianoortizsilva.paginacao.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}