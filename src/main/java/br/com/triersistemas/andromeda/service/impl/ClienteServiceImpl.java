package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import br.com.triersistemas.andromeda.repository.ClienteRepository;
import br.com.triersistemas.andromeda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> consultar() {
        return clienteRepository.findAll().stream().map(ClienteModel::new).collect(Collectors.toList());
    }

    @Override
    public ClienteModel consultar(UUID id) {
        return new ClienteModel(buscarPeloId(id));
    }

    @Override
    public ClienteModel cadastrar(ClienteModel model) {
        Cliente cliente = new Cliente(model);
        return new ClienteModel(clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel alterar(ClienteModel model) {
        Cliente cliente = this.buscarPeloId(model.getId());
        cliente.editar(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
        return new ClienteModel(clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel remover(UUID id) {
        Cliente cliente = this.buscarPeloId(id);
        clienteRepository.delete(cliente);
        return new ClienteModel(cliente);
    }

    private Cliente buscarPeloId(UUID id){
        Cliente cliente = this.clienteRepository.findById(id).orElseThrow(NaoExisteException::new);
        return cliente;
    }
}
