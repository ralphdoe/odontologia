package co.microservices.appointmentScheduler.services;

/**
 * Created by rafaellopez on 12/15/17.
 */

import co.microservices.appointmentScheduler.model.Appointment;

public interface AppointmentService {
    Appointment save(final Appointment appointment);
}
