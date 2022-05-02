package br.com.alura.oobj.producer;

import br.com.alura.oobj.application.ResultadoProcessamento;

public class RelatorioService {
    private ResultadoProcessamentoRelatorioConverter resultadoProcessamentoRelatorioConverter = new ResultadoProcessamentoRelatorioConverter();
    private ModeloXMLConverter modeloXMLConverter = new ModeloXMLConverter();
    private Produtor produtor = new Produtor();

    public void enviarRelatorio (ResultadoProcessamento resultadoProcessamento) throws Exception {

        // Transforma resultado processamento em relatorio pedido
        RelatorioDePedido relatorioDePedido = resultadoProcessamentoRelatorioConverter.converte(resultadoProcessamento);

        // Tranforma relatorio pedido em XML
        String xmlRelatorioDePedido = modeloXMLConverter.converte(relatorioDePedido);

        // Pega XML e envia para o activemq
        produtor.produzMensagem(xmlRelatorioDePedido);
    }
}
