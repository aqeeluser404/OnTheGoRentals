package za.ac.cput.controllers.admin;
/**
 * AdminCarController.java
 * This is the controller for the Car entity
 * Author: Peter Buckingham (220165289)
 * Date: 05 April 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.impl.Car;
import za.ac.cput.domain.impl.PriceGroup;
import za.ac.cput.service.impl.ICarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/cars")
public class AdminCarController {
    @Autowired
    private ICarServiceImpl carService;

    //@RequestMapping("/api/admin/cars")
    @GetMapping("/all")
    public List<Car> getCars() {
        List<Car> allCars = new ArrayList<>(carService.getAll());
        return allCars;
    }

    //@RequestMapping("/api/admin/cars")
    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        System.out.println("/api/admin/cars/create was triggered");
        car.setPriceGroup(mapPriceGroup(car.getPriceGroupString()));
        System.out.println("PriceGroup was set to: " + car.getPriceGroup());
        System.out.println("CarService was created...attempting to create car...");
        Car createdCar = carService.create(car);
        return createdCar;
    }

    //read
    //@RequestMapping("/api/admin/cars")
    @GetMapping("/read/{carId}")
    public Car readCar(@PathVariable Integer carId) {
        System.out.println("/api/admin/cars/read was triggered");
        System.out.println("CarService was created...attempting to read car...");
        Car readCar = carService.read(carId);
        return readCar;
    }

    //@RequestMapping("/api/admin/cars")
    @PutMapping("/update/{carId}")
    public Car updateCar(@PathVariable int carId, @RequestBody Car updatedCar) {
        Car updated = carService.update(updatedCar);
        return updated;
    }

    ///@RequestMapping("/api/admin/cars")
    @DeleteMapping("/delete/{carId}")
    public boolean deleteCar(@PathVariable Integer carId) {
        System.out.println("/api/admin/cars/delete was triggered");
        System.out.println("CarService was created...attempting to delete car...");
        return carService.delete(carId);
    }

    private PriceGroup mapPriceGroup(String priceGroupString) {
        try {
            return PriceGroup.valueOf(priceGroupString);
        } catch (IllegalArgumentException e) {
            return PriceGroup.NONE;
        }
    }


}
//.delete(`http://localhost:8080/api/admin/cars/delete/${carId}`)