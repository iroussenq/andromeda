package br.com.triersistemas.andromeda.repository.impl;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private static final List<Cliente> LIST = new ArrayList<>();

    @Override
    public List<Cliente> pegaTodosOsClientes() {
        return LIST;
    }

    @Override
    public Optional<Cliente> pegaUmCliente(UUID id) {
        return LIST.stream().filter(Cliente -> id.equals(Cliente.getId())).findFirst();
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        LIST.add(cliente);
    }

    @Override
    public void excluirCliente(Cliente cliente) {
        LIST.remove(cliente);
    }
}
