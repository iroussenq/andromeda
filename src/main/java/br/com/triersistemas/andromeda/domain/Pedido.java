package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.enums.EnumStatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name ="pedido")
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",insertable = false,updatable = false,nullable = false,unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "farmaceutico_id",referencedColumnName = "id")
    private Farmaceutico farmaceutico;

    @ManyToMany
    @JoinTable(name = "pedido_produto",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;
    private BigDecimal valor;
    @Column(name= "valor_pago")
    private BigDecimal valorPago;
    private BigDecimal troco;
    private LocalDateTime data;
    @Column(name ="data_pagamento")
    private LocalDateTime dataPagamento;
    @Enumerated(EnumType.STRING)
    private EnumStatusPedido status;

    public Pedido(final Cliente cliente, final Farmaceutico farmaceutico) {
        this.cliente = cliente;
        this.farmaceutico = farmaceutico;
        this.produtos = new ArrayList<>();
        this.valor = BigDecimal.ZERO;
        this.valorPago = BigDecimal.ZERO;
        this.troco = BigDecimal.ZERO;
        this.data = LocalDateTime.now();
        this.status = EnumStatusPedido.PENDENTE;
    }

    public Pedido addProdutos(final List<Produto> produtos) {
        if (EnumStatusPedido.PENDENTE.equals(this.status)) {
            this.produtos.addAll(produtos);
            this.valor = this.produtos.stream()
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return this;
    }

    public Pedido pagar(final BigDecimal valor) {
        if (EnumStatusPedido.PENDENTE.equals(this.status) && valor.compareTo(this.valor) >= 0) {
            this.valorPago = valor;
            this.troco = this.valorPago.subtract(this.valor);
            this.dataPagamento = LocalDateTime.now();
            this.status = EnumStatusPedido.PAGO;
        }
        return this;
    }
}
