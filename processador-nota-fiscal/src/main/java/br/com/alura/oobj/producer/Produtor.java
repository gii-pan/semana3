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

        Message message = session.createTextMessage(mensagem);
        producer.send(message);

        session.close();
        connection.close();
        context.close();
    }
}
