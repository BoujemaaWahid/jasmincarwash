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

import jasmin.carwash.jsw.models.employee.EmployeeDto;
import jasmin.carwash.jsw.services.employee.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> findAll(){
        return employeeService.findAll();
    }


    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable("id") Integer id){
        return null;
    }

    @PostMapping
    public void save(@RequestBody EmployeeDto employeeDto){
        employeeService.save(employeeDto);
    }
    
    @PutMapping
    public void update(@RequestBody EmployeeDto employeeDto){
        if( employeeDto.getId() == null ) return;
        employeeService.save(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){

    }


}
