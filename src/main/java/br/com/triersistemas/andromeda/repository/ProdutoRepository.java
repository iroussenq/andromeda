package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto,UUID> {
    @Query(value = "SELECT * " +
            "FROM produto p " +
            "JOIN pedido_produto pp ON p.id = pp.produto_id WHERE pp.pedido_id = ?1",nativeQuery = true)
    List<Produto> buscarPorPedido(UUID idPedido);
}
