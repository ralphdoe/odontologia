package co.microservices.appointmentScheduler.rabbit.configuration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Configuration RabbitMQ Class
 * Created by rafaellopez on 11/25/17.
 */
@Configuration
public class RabbitConfiguration {

    private static final String SERVER = "spider.rmq.cloudamqp.com";
    private static final String USER = "srjatewm";
    private static final String PASSWORD = "0Tg58e8Yzgfz8Aec-ShZMoxRlHZ6U9T2";
    private static final String QUEUE = "odontologia.cita.solicitudCita";

    @Bean
    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory(SERVER);
        connectionFactory.setUsername(USER);
        connectionFactory.setPassword(PASSWORD);
        //connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost(USER);
        connectionFactory.setChannelCheckoutTimeout(10000);
        connectionFactory.setRequestedHeartBeat(30);
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer container(final ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container
                = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(new ConsumerListener());
        container.setQueueNames(QUEUE);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);

        return container;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    static void createQueue(final String queueName) {
        try {
            com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
            connectionFactory.setHost(SERVER);
            connectionFactory.setUsername(USER);
            connectionFactory.setPassword(PASSWORD);
            connectionFactory.setVirtualHost(USER);
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(queueName, false, false, false, null);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
