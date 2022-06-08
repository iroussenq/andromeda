package br.com.triersistemas.andromeda.model;

import java.time.LocalDate;

public class ClienteModel {
	private String nome;
	private LocalDate niver;
	private String cpf;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public LocalDate getNiver() {
		return niver;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
}
