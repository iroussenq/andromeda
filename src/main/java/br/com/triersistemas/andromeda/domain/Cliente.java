package br.com.triersistemas.andromeda.domain;

import java.time.LocalDate;

import br.com.triersistemas.andromeda.util.StringUtils;

public class Cliente extends PessoaFisica{

	private String email;

	public Cliente(final String nome, final LocalDate niver,final String cpf,final String email) {
		super(nome, niver, cpf);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Cliente editar(final String nome, final LocalDate niver, final String cpf, String email) {
		super.editar(nome, niver,cpf);
		this.email = email;
		return this;
	}
}