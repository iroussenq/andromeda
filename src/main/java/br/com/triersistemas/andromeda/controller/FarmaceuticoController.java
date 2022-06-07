package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    private static final List<Farmaceutico> ListaFarmaceutico = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return ListaFarmaceutico;
    }

    @PostMapping("/cadastrar")
    public List<Farmaceutico> cadastrar(@RequestBody FarmaceuticoModel model) {
        ListaFarmaceutico.add(new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf()));
        return ListaFarmaceutico;
    }

    @PutMapping("/alterar/{index}")
    public List<Farmaceutico> alterar(@PathVariable int index, @RequestBody FarmaceuticoModel model) {
        ListaFarmaceutico.remove(index);
        ListaFarmaceutico.add(new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf()));
        return ListaFarmaceutico;
    }

    @DeleteMapping("/remover/{index}")
    public List<Farmaceutico> remover(@PathVariable int index) {
        ListaFarmaceutico.remove(index);
        return ListaFarmaceutico;
    }
}
