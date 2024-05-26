package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Scooter;
import za.ac.cput.service.impl.ScooterService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/scooter")
public class ScooterController {

    @Autowired
    private ScooterService scooterService;

    @PostMapping("/create")
    public Scooter create(@RequestBody Scooter scooter) {
        return scooterService.create(scooter);
    }

    @GetMapping("/get/{numberPlate}")
    public Scooter read(@PathVariable String numberPlate) {
        return scooterService.read(numberPlate);
    }

    @PostMapping("/update")
    public Scooter update(@RequestBody Scooter scooter) {
        return scooterService.update(scooter);
    }

    @DeleteMapping("/delete/{numberPlate}")
    public boolean delete(@PathVariable String numberPlate) {
        return scooterService.delete(numberPlate);
    }

    @GetMapping("/getAll")
    public List<Scooter> getAll() {
        return scooterService.getAll();
    }
}
