package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.ClienteModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    public static final List<Cliente> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Cliente> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody ClienteModel model) {
    	Cliente c = new Cliente(model.getNome(),model.getNiver() , model.getCpf(), model.getEmail());
        LIST.add(c);
        return c;
    }

    @PutMapping("/alterar/{id}")
    public Cliente alterar(@PathVariable UUID id, @RequestBody ClienteModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getNiver(), model.getCpf(),model.getEmail());
        return domain;
    }

    @DeleteMapping("/remover/{id}")
    public Cliente remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}
