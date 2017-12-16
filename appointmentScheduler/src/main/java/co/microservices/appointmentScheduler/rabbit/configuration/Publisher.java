package co.microservices.appointmentScheduler.rabbit.configuration;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Publisher
 * Created by rafaellopez on 11/25/17.
 */
@Component
public class Publisher {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Publisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessageSynchronous(final String exchange, final String routingKey, final String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
