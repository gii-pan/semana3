package br.com.alura.oobj.producer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class ModeloXMLConverter {

    public String converte(RelatorioDePedido relatorioDePedido){
        try {
            ObjectMapper xmlMapper = new ObjectMapper();
            return  xmlMapper.writeValueAsString(relatorioDePedido);

        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
