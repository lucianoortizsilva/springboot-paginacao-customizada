package com.lucianoortizsilva.paginacao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucianoortizsilva.paginacao.dto.PessoaDTO;
import com.lucianoortizsilva.paginacao.model.Pessoa;
import com.lucianoortizsilva.paginacao.service.PessoaService;
import com.lucianoortizsilva.paginacao.util.Util;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

	private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);
	
	@Autowired
	private PessoaService service;

	@GetMapping
	public Page<PessoaDTO> get(@RequestParam(value = "page", required = false, defaultValue = "0") int page, 
			                   @RequestParam(value = "size", required = false, defaultValue = "5") int size,
			                   @RequestParam(value = "filtroApelido", required = false) String filtroApelido) {

		final List<Pessoa> todasPessoas = this.service.getAll();
		logger.info("Quantidade pessoas antes do filtro: {}", todasPessoas.size());
				
		final List<PessoaDTO> pessoasComApelidos = this.service.atualizarApelidos(todasPessoas);
		logger.info("Apelidos adicionados");
		
		this.service.filtrar(pessoasComApelidos, filtroApelido);
		logger.info("Quantidade pessoas depois de filtrar: {}", pessoasComApelidos.size());
		
		final List<PessoaDTO> pessoasPorPagina = Util.getListByPage(pessoasComApelidos, page, size);
		
		final Pageable pageable = PageRequest.of(page, size);
		
		return new PageImpl<>(pessoasPorPagina, pageable, pessoasComApelidos.size());
	}

}