package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

public class Fornecedor extends PessoaJuridica {

    private List<Produto> produtos;

    public Fornecedor() {
        this.produtos = StringUtils.getRandomMeds();
    }

    public Fornecedor(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver, cnpj);
        this.produtos = StringUtils.getRandomMeds();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}