package br.com.triersistemas.andromeda.repository.impl;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.domain.Produto;
import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.repository.FarmaceuticoRepository;
import br.com.triersistemas.andromeda.repository.ProdutoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FarmaceuticoRepositoryImpl implements FarmaceuticoRepository {

    private static final List<Farmaceutico> LIST = new ArrayList<>();

    @Override
    public List<Farmaceutico> pegaTodosOsFarmaceuticos() {
        return LIST;
    }

    @Override
    public Optional<Farmaceutico> pegaUmFarmaceutico(UUID id) {
        return LIST.stream().filter(farmaceutico -> id.equals(farmaceutico.getId())).findFirst();
    }

    @Override
    public void inserirFarmaceutico(Farmaceutico farmaceutico) {
        LIST.add(farmaceutico);
    }

    @Override
    public void excluirFarmaceutico(Farmaceutico farmaceutico) {
        LIST.remove(farmaceutico);
    }
}
