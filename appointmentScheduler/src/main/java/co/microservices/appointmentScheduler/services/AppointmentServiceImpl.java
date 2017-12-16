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

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(final Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
