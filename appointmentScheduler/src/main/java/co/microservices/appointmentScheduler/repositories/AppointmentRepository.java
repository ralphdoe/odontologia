package co.microservices.appointmentScheduler.repositories;

import co.microservices.appointmentScheduler.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Appointment Repository.
 * Created by rafaellopez on 12/15/17.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
