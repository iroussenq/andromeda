package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import br.com.triersistemas.andromeda.model.ProdutoModel;
import br.com.triersistemas.andromeda.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/consultar")
    public List<ProdutoModel> consultar() {
        return produtoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public ProdutoModel consultarPorIds(@PathVariable UUID id) {
        return produtoService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public ProdutoModel cadastrar(@RequestBody ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public ProdutoModel alterar(@RequestBody ProdutoModel model) {
        return produtoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ProdutoModel remover(@PathVariable UUID id) {
        return produtoService.remover(id);
    }

    @GetMapping("/buscar-por-pedido/{id}")
    public List<ProdutoModel> buscarPorPedido(@PathVariable UUID id){
        return produtoService.buscarPorPedido(id);
    }
}
