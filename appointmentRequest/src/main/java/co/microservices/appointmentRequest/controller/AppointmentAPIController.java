package co.microservices.appointmentRequest.controller;

import co.microservices.appointmentRequest.model.Appointment;
import co.microservices.appointmentRequest.rabbit.configuration.Publisher;
import co.microservices.appointmentRequest.utilities.JSonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Appointment API Controller
 * Created by rafaellopez on 12/14/17.
 */
@RestController
public class AppointmentAPIController {

    private static final String EXCHANGE = "cita";
    final private Publisher publisher = new Publisher();

    @RequestMapping(method = RequestMethod.POST, value = "/appointment")
    public ResponseEntity<Appointment> requestAppointment(@RequestBody final Appointment appointment) {
        publisher.publishMessageSynchronous(EXCHANGE, "", JSonMapper.convertToJSON(appointment));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
