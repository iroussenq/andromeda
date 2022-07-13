package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.model.FornecedorModel;

import java.util.List;
import java.util.UUID;

public interface FornecedorService {
    List<FornecedorModel> consultar();
    FornecedorModel consultar(UUID id);
    FornecedorModel cadastrarRandom();
    FornecedorModel cadastrar(FornecedorModel model);
    FornecedorModel alterar(FornecedorModel model);
    FornecedorModel remover(UUID id);
}
