package br.com.triersistemas.andromeda.model;

import java.time.LocalDate;

public class FornecedorModel {
    private String nome;
    private LocalDate niver;
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public LocalDate getNiver() {
        return niver;
    }

    public String getCnpj() {
        return cnpj;
    }

}
