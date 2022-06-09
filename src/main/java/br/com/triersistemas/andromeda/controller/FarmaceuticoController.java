package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    public static final List<Farmaceutico> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public List<Farmaceutico> cadastrar(@RequestBody FarmaceuticoModel model) {
        LIST.add(new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf()));
        return LIST;
    }

    @PostMapping("/cadastrar-random")
    public List<Farmaceutico> cadastrarRandom() {
        LIST.add(new Farmaceutico());
        return LIST;
    }

    @PutMapping("/alterar/{id}")
    public List<Farmaceutico> alterar(@PathVariable UUID id, @RequestBody FarmaceuticoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getNiver(), model.getCpf());
        return LIST;
    }

    @DeleteMapping("/remover/{id}")
    public List<Farmaceutico> remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return LIST;
    }
}
