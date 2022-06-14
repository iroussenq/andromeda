package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import br.com.triersistemas.andromeda.repository.ClienteRepository;
import br.com.triersistemas.andromeda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultar() {
        return clienteRepository.pegaTodosOsClientes();
    }

    @Override
    public Cliente consultar(UUID id) {
        return clienteRepository.pegaUmCliente(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Cliente cadastrar(ClienteModel model) {
        Cliente cliente = new Cliente(model.getNome(),model.getNiver(),model.getNome(), model.getEmail());
        clienteRepository.inserirCliente(cliente);
        return cliente;
    }

    @Override
    public Cliente alterar(UUID id, ClienteModel model) {
        Cliente cliente = this.consultar(id);
        cliente.editar(model.getNome(), model.getNiver(), model.getCpf(), model.getEmail());
        return cliente;
    }

    @Override
    public Cliente remover(UUID id) {
        Cliente cliente = this.consultar(id);
        clienteRepository.excluirCliente(cliente);
        return cliente;
    }
}
