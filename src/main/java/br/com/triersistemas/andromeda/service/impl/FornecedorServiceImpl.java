package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import br.com.triersistemas.andromeda.model.FornecedorModel;
import br.com.triersistemas.andromeda.repository.FornecedorRepository;
import br.com.triersistemas.andromeda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<FornecedorModel> consultar() {
        return fornecedorRepository.findAll().stream().map(FornecedorModel::new).collect(Collectors.toList());
    }

    @Override
    public FornecedorModel consultar(UUID id) {
        return new FornecedorModel(this.buscarPorId(id));
    }


    @Override
    public FornecedorModel cadastrarRandom() {
        Fornecedor fornecedor = new Fornecedor();
        return new FornecedorModel(fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorModel cadastrar(FornecedorModel model) {
        Fornecedor fornecedor = new Fornecedor(model);
        return new FornecedorModel(fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorModel alterar(FornecedorModel model) {
        Fornecedor fornecedor = this.buscarPorId(model.getId());
        fornecedor.editar(model.getNome(), model.getNiver(), model.getCnpj());
        return new FornecedorModel(this.fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorModel remover(UUID id) {
        Fornecedor fornecedor = this.buscarPorId(id);
        fornecedorRepository.delete(fornecedor);
        return new FornecedorModel(fornecedor);
    }
    private Fornecedor buscarPorId(UUID id) {
        return this.fornecedorRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
