package br.com.triersistemas.andromeda.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private final UUID id;
    private Farmaceutico farmaceutico;
    private Cliente cliente;
    private List<Produto> produtos;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal trocado;
    private LocalDateTime dataEmissao;
    private LocalDateTime pagamento;
    private LocalDateTime cancelamento;

    public Pedido(final Farmaceutico farmaceutico, final Cliente cliente) {
        this.id = UUID.randomUUID();
        this.farmaceutico = farmaceutico;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.valor = BigDecimal.ZERO;
        this.valorPago = BigDecimal.ZERO;
        this.trocado = BigDecimal.ZERO;
        this.dataEmissao = LocalDateTime.now();
    }

    public Pedido adicionaProdutos(final List<Produto> produtos) {
            this.produtos.addAll(produtos);
            this.valor = this.produtos.stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        return this;
    }

    public Pedido pagar(final BigDecimal valor) {
        if (valor.compareTo(this.valor) > 0) {
            this.valorPago = valor;
            this.trocado = this.valorPago.subtract(this.valor);
            this.pagamento = LocalDateTime.now();
        }
        return this;
    }

	public UUID getId() {
		return id;
	}

	public Farmaceutico getFarmaceutico() {
		return farmaceutico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public BigDecimal getTrocado() {
		return trocado;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public LocalDateTime getPagamento() {
		return pagamento;
	}

	public LocalDateTime getCancelamento() {
		return cancelamento;
	}
    
}
