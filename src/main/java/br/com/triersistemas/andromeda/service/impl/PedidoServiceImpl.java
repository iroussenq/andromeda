package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.*;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.AdicionarProdutoModel;
import br.com.triersistemas.andromeda.model.PagarPedidoModel;
import br.com.triersistemas.andromeda.model.PedidoModel;
import br.com.triersistemas.andromeda.repository.PedidoRepository;
import br.com.triersistemas.andromeda.service.ClienteService;
import br.com.triersistemas.andromeda.service.FarmaceuticoService;
import br.com.triersistemas.andromeda.service.PedidoService;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FarmaceuticoServiceImpl farmaceuticoServiceImpl;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @Override
    public List<PedidoModel> consultar() {
        return pedidoRepository.findAll().stream().map(PedidoModel::new).toList();
    }

    @Override
    public PedidoModel consultar(UUID id) {
        return new PedidoModel((this.buscarPorId(id)));
    }

    @Override
    public PedidoModel cadastrar (PedidoModel model){
        var cliente = clienteServiceImpl.consultaPorCliente(model.getCliente().getId());
        var farmaceutico = farmaceuticoServiceImpl.consultaPorFarmaceutico(model.getFarmaceutico().getId());
        var pedido = new Pedido(cliente, farmaceutico);
        return new PedidoModel(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoModel adicionarProduto(UUID id, AdicionarProdutoModel model) {
        Pedido pedido = this.buscarPorId(id);
        List<Produto> produtos = produtoServiceImpl.consultarProdutos(model.getIdsProdutos());
        pedido.addProdutos(produtos);
        return new PedidoModel(pedidoRepository.save(pedido));
    }

    @Override
    public Pedido pagar (UUID id, PagarPedidoModel model){
        var pedido = this.buscarPorId(id);
        return pedido.pagar(model.getValor());
    }


    private Pedido buscarPorId(UUID id){
        return this.pedidoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }


    }


