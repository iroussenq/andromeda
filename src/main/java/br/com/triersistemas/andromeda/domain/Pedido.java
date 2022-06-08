package br.com.triersistemas.andromeda.domain;

import java.util.List;
import java.util.UUID;

import br.com.triersistemas.andromeda.exceptions.NaoExisteException;
import br.com.triersistemas.andromeda.util.StringUtils;

public class Pedido {
	private UUID idPedido;
	private UUID idCliente;
	private String nomeCliente;
	private String nomeFarmaceutico;
	private List<Produto> carrinho;
	private UUID idFarmaceutico;
	private Fornecedor f;
	
	public Pedido(UUID idCliente) {
		this.carrinho = itensCarrinho(null);
	}
	
	public List<Produto> itensCarrinho(String id){
		var domain = carrinho.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
	}
	
}
