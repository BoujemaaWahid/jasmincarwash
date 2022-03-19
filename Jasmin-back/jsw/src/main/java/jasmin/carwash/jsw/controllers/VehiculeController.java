package jasmin.carwash.jsw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jasmin.carwash.jsw.models.Vehicule.VehiculeDto;
import jasmin.carwash.jsw.services.vehicule.VehiculeService;

@CrossOrigin
@RestController
@RequestMapping("/vehicule")
public class VehiculeController {
    @Autowired VehiculeService vehiculeService;

    @GetMapping
    public List<VehiculeDto> findAll(){
        return vehiculeService.findAll();
    }

    @GetMapping("/id")
    public VehiculeDto findById(@PathVariable("id") Long id){
        return vehiculeService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody VehiculeDto vehiculeDto){
        vehiculeService.save(vehiculeDto);
    }

    @PutMapping
    public void update(@RequestBody VehiculeDto vehiculeDto){
        vehiculeService.save(vehiculeDto);
    }
}
