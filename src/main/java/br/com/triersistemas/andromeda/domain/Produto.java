package br.com.triersistemas.andromeda.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

	private UUID id;
	private String nome;
	private BigDecimal valor;
	
	public Produto(String nome, BigDecimal valor) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.valor = valor;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}
