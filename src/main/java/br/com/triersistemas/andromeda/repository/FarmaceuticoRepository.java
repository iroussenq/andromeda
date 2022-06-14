package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Cliente;
import br.com.triersistemas.andromeda.domain.Farmaceutico;
import br.com.triersistemas.andromeda.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FarmaceuticoRepository {
    List<Farmaceutico> pegaTodosOsFarmaceuticos();

    Optional<Farmaceutico> pegaUmFarmaceutico(UUID id);

    void inserirFarmaceutico(Farmaceutico farmaceutico);

    void excluirFarmaceutico(Farmaceutico farmaceutico);
}
