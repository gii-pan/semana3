package br.com.alura.oobj.producer;

import br.com.alura.oobj.application.ResultadoProcessamento;
import br.com.alura.oobj.application.SubTotalPorClasseFiscal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItensPorClasseFiscal {

    private String classeFiscal;
    private BigDecimal total;

    public List<SubTotalPorClasseFiscal.Item> retornaSubTotalEClasseFiscal(ResultadoProcessamento resultadoProcessamento) {
        List<SubTotalPorClasseFiscal.Item> listaItem = new ArrayList<>();
        for (SubTotalPorClasseFiscal.Item item : resultadoProcessamento.getSubTotalPorClasseFiscal()) {
            this.classeFiscal = item.getClasseFiscal();
            this.total = item.getSubTotal();
            listaItem.add(item);
        }
        return listaItem;
    }

    public String getClasseFiscal() {
        return classeFiscal;
    }

    public BigDecimal getSubTotal() {
        return total;
    }
}
