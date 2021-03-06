package co.microservices.appointmentRequest.rabbit.configuration;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Publisher
 * Created by rafaellopez on 11/25/17.
 */
@Component
public class Publisher {
    final private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(RabbitConfiguration.class);
    final private RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);

    public void publishMessageSynchronous(final String exchange, final String routingKey, final String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
