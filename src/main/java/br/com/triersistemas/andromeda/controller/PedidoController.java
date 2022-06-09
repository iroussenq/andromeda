package br.com.triersistemas.andromeda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import br.com.triersistemas.andromeda.domain.*;
import br.com.triersistemas.andromeda.exceptions.*;
import br.com.triersistemas.andromeda.model.*;
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	public static final List<Pedido> LIST = new ArrayList<>();
	
	@GetMapping("/consultar")
	public List<Pedido> consultar(){
		return LIST;
	}
	
	@PostMapping("/cadastrar")
	public Pedido cadastrar(@RequestBody PedidoModel model){
		
		Farmaceutico farmaceutico = FarmaceuticoController.LIST.stream()
				.filter(f -> f.getId().equals(model.getIdFarmaceutico()))
				.findFirst()
				.orElseThrow(NaoExisteException::new);
		
		Cliente cliente = ClienteController.LIST.stream()
				.filter(c -> c.getId().equals(model.getIdCliente()))
				.findFirst()
				.orElseThrow(NaoExisteException::new);
		
		Pedido pedido = new Pedido(farmaceutico, cliente);
		LIST.add(pedido);
		return pedido;
	}
	
	@PutMapping("/adicionar-produtos/{id}")
	public Pedido adicionarProdutos(@PathVariable UUID id,@RequestBody AdicionaPedidoModel model) {
		Pedido pedido = LIST.stream()
				.filter(i -> i.getId().equals(model.getIdProdutos()))
				.findFirst()
				.orElseThrow(NaoExisteException::new);
		
		var produtos = model.getIdProdutos().stream()
				.map(idProduto -> {
					return ProdutoController.LIST.stream()
							.filter(p -> p.getId().equals(model.getIdProdutos()))
							.findFirst()
							.orElseThrow(NaoExisteException::new);
				}).collect(Collectors.toList());
		return pedido.adicionaProdutos(produtos);
	}
	
	@PutMapping("/pagar/{id}")
	public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
		Pedido pedido = LIST.stream()
				.filter(x -> x.getId().equals(id))
				.findFirst()
				.orElseThrow(NaoExisteException::new);
		return pedido.pagar(model.getValor()); 
	}
}
