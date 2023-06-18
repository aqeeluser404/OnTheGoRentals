package za.ac.cput.controllers;

/**
 * ReservationsController.java
 * Class for the Reservations Controller
 * Author: Cwenga Dlova (214310671)
 * Date:  13 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.impl.Reservations;
import za.ac.cput.factory.impl.ReservationsFactory;
import za.ac.cput.service.impl.ReservationsServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    @Autowired

    private ReservationsServiceImpl reservationsService;

    @PostMapping("/create")
    public Reservations create(@RequestBody Reservations reservations) {

        Reservations reservationcreated = ReservationsFactory.createReservations(reservations.getPickUpLocation(), reservations.getPickUpDate(), reservations.getPickUpTime(), reservations.getReturnLocation(), reservations.getReturnDate(), reservations.getReturnTme());
        return reservationsService.create(reservations);
        //commented out the other code because i'm avoiding creating different employee id's which might lead an error. haven't tested the class yet but let's see. I return reservations created in the test class
    }

    @PostMapping("/update")
    public Reservations update(@RequestBody Reservations reservations) {
        return reservationsService.update(reservations);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return reservationsService.delete(id);
    }

    @GetMapping("/getall")
    public List<Reservations> getAll() {

        return reservationsService.getAll();
    }
//added static in the factory class (createReservations) because of an error
    //DD3 ended 32:37
}
