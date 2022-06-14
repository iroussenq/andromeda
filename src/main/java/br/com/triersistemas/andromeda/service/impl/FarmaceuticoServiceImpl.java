package br.com.triersistemas.andromeda.service.impl;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.model.FarmaceuticoModel;
import br.com.triersistemas.andromeda.repository.FarmaceuticoRepository;
import br.com.triersistemas.andromeda.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FarmaceuticoServiceImpl implements FarmaceuticoService {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @Override
    public List<Farmaceutico> consultar() {
        return farmaceuticoRepository.pegaTodosOsFarmaceuticos();
    }

    @Override
    public Farmaceutico consultar(UUID id) {
        return farmaceuticoRepository.pegaUmFarmaceutico(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Farmaceutico cadastrar(FarmaceuticoModel model) {
        Farmaceutico f = new Farmaceutico(model.getNome(), model.getNiver(), model.getCpf());
        farmaceuticoRepository.inserirFarmaceutico(f);
        return f;
    }

    @Override
    public Farmaceutico alterar(UUID id, FarmaceuticoModel model) {
        Farmaceutico f = this.consultar(id);
        f.editar(model.getNome(), model.getNiver(), model.getCpf());
        return f;
    }

    @Override
    public Farmaceutico remover(UUID id) {
        Farmaceutico f = this.consultar(id);
        farmaceuticoRepository.excluirFarmaceutico(f);
        return f;
    }
}
