package co.microservices.costCenter.controller;

import co.microservices.costCenter.model.CostCenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * CostCenter API Controller
 * Created by rafaellopez on 12/14/17.
 */
@RestController
public class CostCenterAPIController {

    @RequestMapping(method = RequestMethod.GET, value = "/costcenter")
    public ResponseEntity<List<CostCenter>> getCostCenter() {
        final List<CostCenter> costCenters = new ArrayList<>();
        costCenters.add(new CostCenter("1", "Aguacatala"));
        return new ResponseEntity<>(costCenters, HttpStatus.OK);
    }
}
