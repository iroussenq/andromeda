package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido,UUID> {
}
