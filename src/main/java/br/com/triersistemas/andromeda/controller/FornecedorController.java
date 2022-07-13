package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.model.FornecedorModel;
import br.com.triersistemas.andromeda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/consultar")
    public List<FornecedorModel> consultar() {
        return fornecedorService.consultar();
    }

    @PostMapping("/cadastrar")
    public FornecedorModel cadastrar(@RequestBody FornecedorModel model) {
        return fornecedorService.cadastrar(model);
    }

    @PostMapping("/cadastrar-random")
    public FornecedorModel cadastrarRandom() {
        return fornecedorService.cadastrarRandom();
    }

    @PutMapping("/alterar")
    public FornecedorModel alterar(@RequestBody FornecedorModel model) {
        return fornecedorService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public FornecedorModel remover(@PathVariable UUID id) {
        return fornecedorService.remover(id);
    }
}
