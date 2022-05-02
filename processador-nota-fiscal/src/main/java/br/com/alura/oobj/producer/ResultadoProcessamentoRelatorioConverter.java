package br.com.alura.oobj.producer;

import br.com.alura.oobj.application.ResultadoProcessamento;
import br.com.alura.oobj.application.SubTotalPorClasseFiscal;

import java.util.List;

public class ResultadoProcessamentoRelatorioConverter {
    private final ItensPorClasseFiscal itensPorClasseFiscalList = new ItensPorClasseFiscal();

    public RelatorioDePedido converte(ResultadoProcessamento resultadoProcessamento) {
        List<SubTotalPorClasseFiscal.Item> listaItensSubtotalPorClasseFiscal = itensPorClasseFiscalList.retornaSubTotalEClasseFiscal(resultadoProcessamento);
        RelatorioDePedido relatorioDePedido = new RelatorioDePedido(resultadoProcessamento, listaItensSubtotalPorClasseFiscal);
        return relatorioDePedido;
    }
}
