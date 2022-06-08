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

    private static final List<Cliente> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Cliente> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public List<Cliente> cadastrar(@RequestBody ClienteModel model) {
        LIST.add(new Cliente(model.getNome(),model.getNiver() , model.getCpf(), model.getEmail()));
        return LIST;
    }

    @PutMapping("/alterar/{id}")
    public List<Cliente> alterar(@PathVariable UUID id, @RequestBody ClienteModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editarCliente(model.getNome(), model.getNiver(), model.getCpf(),model.getEmail());
        return LIST;
    }

    @DeleteMapping("/remover/{id}")
    public List<Cliente> remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return LIST;
    }
}
