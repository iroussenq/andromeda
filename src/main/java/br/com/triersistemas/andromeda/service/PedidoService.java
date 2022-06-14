package br.com.triersistemas.andromeda.service;

import br.com.triersistemas.andromeda.controller.PedidoController;
import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> pegaTodosOsPedido();

    Optional<Pedido> pegaUmPedido();

    void inserirPedido(Pedido pedido);

    void excluirPedido();
}
