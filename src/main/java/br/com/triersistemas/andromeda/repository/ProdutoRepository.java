package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto,UUID> {
}
