package co.microservices.appointmentScheduler.controller;

import co.microservices.appointmentScheduler.model.Appointment;
import co.microservices.appointmentScheduler.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rafaellopez on 12/15/17.
 */
@Component
public class ApplicationSchedulerController {
    @Autowired
    private AppointmentService appointmentService;

    public Appointment saveAppointment(Appointment appointment) {
        Appointment save = appointmentService.save(appointment);
        System.out.println(save);
        return save;
    }
}
