package co.microservices.appointmentScheduler.services;

import co.microservices.appointmentScheduler.model.Appointment;
import co.microservices.appointmentScheduler.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Appointment Service.
 * Created by rafaellopez on 12/15/17.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment save(final Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
