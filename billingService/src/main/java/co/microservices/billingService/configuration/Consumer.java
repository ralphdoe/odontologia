package co.microservices.billingService.configuration;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Consumer
 * Created by rafaellopez on 11/25/17.
 */
@Component
public class Consumer implements MessageListener {

    @Override
    public void onMessage(final Message message) {
        System.out.println("Billed: " + message);
    }
}
