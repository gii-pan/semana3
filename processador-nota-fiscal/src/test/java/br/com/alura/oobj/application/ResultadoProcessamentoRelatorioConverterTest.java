package br.com.alura.oobj.application;

import br.com.alura.oobj.producer.ItensPorClasseFiscal;
import br.com.alura.oobj.producer.RelatorioDePedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ResultadoProcessamentoRelatorioConverterTest {

    @Mock
    private LeitorFonteDados leitor;

    @Test
    void verificaConversaoDeResultadoProcessamentoParaRelatorioDePedido() {
        ItemPedido itemPedido1 = criaItemPedido("2202.10.00", 1, new BigDecimal("59.99"));
        ItemPedido itemPedido2 = criaItemPedido("2202.10.00", 2, new BigDecimal("9.99"));
        List<ItemPedido> itens = Arrays.asList(itemPedido1, itemPedido2);
        Pedido pedido = new Pedido(itens);

        Mockito.when(leitor.recupera("itens")).thenReturn(pedido);

        ProcessadorFonteDados processador = new ProcessadorFonteDados(leitor);
        ResultadoProcessamento resultado = processador.processa("itens");

        ItensPorClasseFiscal itensPorClasseFiscalList = new ItensPorClasseFiscal();

        List<SubTotalPorClasseFiscal.Item> listaItensSubtotalPorClasseFiscal = itensPorClasseFiscalList.retornaSubTotalEClasseFiscal(resultado);

        RelatorioDePedido relatorioDePedido = new RelatorioDePedido(resultado,listaItensSubtotalPorClasseFiscal);

        Assertions.assertEquals(relatorioDePedido.getTotalPedido(), resultado.getTotalPedido());
        Assertions.assertEquals(relatorioDePedido.getListaDeItensPorClasseFiscalistaItens(), listaItensSubtotalPorClasseFiscal);

    }

    private ItemPedido criaItemPedido(String classeFiscal, int quantidade, BigDecimal valorUnitario) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setClasseFiscal(classeFiscal);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorUnitario(valorUnitario);
        return itemPedido;
    }
}