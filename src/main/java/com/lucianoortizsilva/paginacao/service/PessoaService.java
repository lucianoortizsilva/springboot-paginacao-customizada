package com.lucianoortizsilva.paginacao.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lucianoortizsilva.paginacao.dto.PessoaDTO;
import com.lucianoortizsilva.paginacao.model.Pessoa;
import com.lucianoortizsilva.paginacao.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Cacheable(value = "pessoasAll")
	public List<Pessoa> getAll() {
		return this.repository.findAll(Sort.by("id").ascending());
	}
	
	public List<PessoaDTO> atualizarApelidos(final List<Pessoa> pessoas) {
		final String apelidos[] = { "Thanos", "Hulk" };
		final List<PessoaDTO> pessoasComApelidos = new ArrayList<>();
		for (final Pessoa pessoa : pessoas) {
			final PessoaDTO p = new PessoaDTO();
			p.setNome(pessoa.getNome());
			p.setApelido(apelidos[getNumeroAleatorio()]);
			pessoasComApelidos.add(p);
		}
		return pessoasComApelidos;
	}

	public void filtrar(final List<PessoaDTO> pessoas, final String apelido) {
		if (!CollectionUtils.isEmpty(pessoas) && StringUtils.isNotEmpty(apelido)) {
			final Iterator<PessoaDTO> it = pessoas.iterator();
			while (it.hasNext()) {
				final PessoaDTO p = it.next();
				if (!p.getApelido().equalsIgnoreCase(apelido)) {
					it.remove();
				}
			}
		}
	}

	private static int getNumeroAleatorio() {
		return (int) (Math.random() * 2);
	}
	
}