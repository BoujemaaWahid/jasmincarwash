package jasmin.carwash.jsw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jasmin.carwash.jsw.models.formule.FormuleDto;
import jasmin.carwash.jsw.services.formule.FormuleService;

@CrossOrigin
@RestController
@RequestMapping("/formule")
public class FormuleController {
    @Autowired FormuleService formuleService;

    @GetMapping
    public List<FormuleDto> findAll(){
        return formuleService.findAll();
    }

    @GetMapping("/{id}")
    public FormuleDto findById(@PathVariable("id") Integer id){
        return formuleService.findById(id);
    }
    @PostMapping
    public void save(@RequestBody FormuleDto formuleDto){
        formuleService.save(formuleDto);
    }

    @PutMapping
    public void update(@RequestBody FormuleDto formuleDto){
        formuleService.save(formuleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        formuleService.delete(id);
    }

}
