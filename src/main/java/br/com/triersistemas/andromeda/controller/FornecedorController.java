package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.model.FornecedorModel;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private static final List<Fornecedor> ListaFornecedor = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Fornecedor> consultar() {
        return ListaFornecedor;
    }

    @PostMapping("/cadastrar")
    public List<Fornecedor> cadastrar(@RequestBody FornecedorModel model) {
        ListaFornecedor.add(new Fornecedor(model.getNome(), model.getNiver(), model.getCnpj()));
        return ListaFornecedor;
    }

    @PutMapping("/alterar/{index}")
    public List<Fornecedor> alterar(@PathVariable int index, @RequestBody FornecedorModel model) {
        ListaFornecedor.remove(index);
        ListaFornecedor.add(new Fornecedor(model.getNome(), model.getNiver(), model.getCnpj()));
        return ListaFornecedor;
    }

    @DeleteMapping("/remover/{index}")
    public List<Fornecedor> remover(@PathVariable int index) {
        ListaFornecedor.remove(index);
        return ListaFornecedor;
    }
}
