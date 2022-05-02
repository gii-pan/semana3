package br.com.alura.oobj.producer;

import br.com.alura.oobj.application.ResultadoProcessamento;
import br.com.alura.oobj.application.SubTotalPorClasseFiscal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RelatorioDePedido {

    private UUID id;
    private BigDecimal totalPedido;
    private LocalDateTime data;
    private List<SubTotalPorClasseFiscal.Item> listaDeItensPorClasseFiscal= new ArrayList<>();

    public RelatorioDePedido() {}
    public RelatorioDePedido(ResultadoProcessamento resultadoProcessamento, List<SubTotalPorClasseFiscal.Item> listaItens) {
        this.id = UUID.randomUUID();
        this.totalPedido = resultadoProcessamento.getTotalPedido();
        this.data = LocalDateTime.now();
        this.listaDeItensPorClasseFiscal = listaItens;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public List<SubTotalPorClasseFiscal.Item> getListaDeItensPorClasseFiscalistaItens() {
        return listaDeItensPorClasseFiscal;
    }

}
