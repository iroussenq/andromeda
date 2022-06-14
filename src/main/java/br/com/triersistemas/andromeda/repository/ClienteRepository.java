package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    List<Cliente> pegaTodosOsClientes();

    Optional<Cliente> pegaUmCliente(UUID id);

    void inserirCliente(Cliente cliente);

    void excluirCliente(Cliente cliente);
}
