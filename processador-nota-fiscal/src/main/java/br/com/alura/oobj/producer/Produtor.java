package br.com.alura.oobj.producer;

import javax.jms.*;
import javax.naming.InitialContext;

public class Produtor {

    public void produzMensagem(String mensagem) throws Exception{
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("financeiro");
        MessageProducer producer = session.createProducer(fila);

        for(int I=0; I<1000; I++){
            Message message = session.createTextMessage(mensagem + I);
            producer.send(message);
        }


        session.close();
        connection.close();
        context.close();
    }
}
