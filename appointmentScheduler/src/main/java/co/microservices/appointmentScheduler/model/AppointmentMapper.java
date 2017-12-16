package co.microservices.appointmentScheduler.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by rafaellopez on 12/15/17.
 */
public class AppointmentMapper {
    public static Appointment getAppointment(final byte[] message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(message, Appointment.class);
        } catch (IOException e) {
            return null;
        }
    }
}
