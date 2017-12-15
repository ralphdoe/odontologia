package co.microservices.appointmentRequest.rabbit.configuration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration RabbitMQ Class
 * Created by rafaellopez on 11/25/17.
 */
@Configuration
public class RabbitConfiguration {

    private static final String SERVER = "spider.rmq.cloudamqp.com";
    private static final String USER = "srjatewm";
    private static final String PASSWORD = "0Tg58e8Yzgfz8Aec-ShZMoxRlHZ6U9T2";

    @Bean
    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory(SERVER);
        connectionFactory.setUsername(USER);
        connectionFactory.setPassword(PASSWORD);
        connectionFactory.setVirtualHost(USER);
        connectionFactory.setChannelCheckoutTimeout(10000);
        connectionFactory.setRequestedHeartBeat(30);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }
}
