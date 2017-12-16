package co.microservices.appointmentScheduler.rabbit.configuration;

import co.microservices.appointmentScheduler.model.Appointment;
import co.microservices.appointmentScheduler.model.AppointmentMapper;
import co.microservices.appointmentScheduler.services.AppointmentService;
import co.microservices.appointmentScheduler.utilities.JSonMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Consumer
 * Created by rafaellopez on 11/25/17.
 */
@Component
public class ConsumerListener implements MessageListener {

    private final AppointmentService appointmentService;
    private final Publisher publisher;

    @Autowired
    public ConsumerListener(AppointmentService appointmentService, Publisher publisher) {
        this.appointmentService = appointmentService;
        this.publisher = publisher;
    }

    @Override
    public void onMessage(final Message message) {
        Appointment appointment = AppointmentMapper.getAppointment(message.getBody());

        Appointment save = appointmentService.save(appointment);
        System.out.println(save);
        RabbitConfiguration.createQueue(appointment.getPatientId());

        publisher.publishMessageSynchronous("respuestaAsignacionCita", appointment.getPatientId(), JSonMapper.convertToJSON(appointment.getCode()));
        publisher.publishMessageSynchronous("factura", appointment.getPatientId(), JSonMapper.convertToJSON(appointment.getCode()));
        publisher.publishMessageSynchronous("log", appointment.getPatientId(), JSonMapper.convertToJSON(appointment.getCode()));
    }
}
