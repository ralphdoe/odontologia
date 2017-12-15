package co.microservices.appointmentScheduler.rabbit.configuration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Consumer
 * Created by rafaellopez on 11/25/17.
 */
@Component
public class Consumer implements MessageListener {

    private static final String SERVER = "spider.rmq.cloudamqp.com";
    private static final String USER = "srjatewm";
    private static final String PASSWORD = "0Tg58e8Yzgfz8Aec-ShZMoxRlHZ6U9T2";
    private static final String QUEUE = "3";

    @Override
    public void onMessage(final Message message) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(SERVER);
            connectionFactory.setUsername(USER);
            connectionFactory.setPassword(PASSWORD);
            connectionFactory.setVirtualHost(USER);
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE, false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
