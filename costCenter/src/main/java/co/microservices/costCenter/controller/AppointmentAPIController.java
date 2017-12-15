package co.microservices.costCenter.controller;

import co.microservices.costCenter.model.Appointment;
import co.microservices.costCenter.model.CostCenter;
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

    @RequestMapping(method = RequestMethod.GET, value = "/costcentergit")
    public ResponseEntity<CostCenter> getCostCenter(@RequestBody final Appointment appointment) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
