package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class FornecedorModel {
    private UUID id;
    private String nome;
    private LocalDate niver;
    private String cnpj;
    private List<Produto> produtos;
    private Long idade;
    private String documento;
    private Boolean documentoValido;

    public FornecedorModel(Fornecedor Fornecedor){
        this.id = Fornecedor.getId();
        this.nome = Fornecedor.getNome();
        this.niver = Fornecedor.getNiver();
        this.cnpj = Fornecedor.getDocumento();
        this.produtos = getProdutos();
        this.documento = Fornecedor.getDocumento();
        this.idade = Fornecedor.getIdade();
        this.documentoValido = Fornecedor.getDocumentoValido();
    }

    public List<ProdutoModel> criaListaProduto(List<Produto> produtos) {
        if(Objects.isNull(produtos)){
            return produtos.stream().map(ProdutoModel::new).toList();
        } else {
            return new ArrayList<>();
        }
    }
}
