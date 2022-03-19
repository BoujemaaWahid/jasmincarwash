package jasmin.carwash.jsw.services.employee;

import java.util.List;

import jasmin.carwash.jsw.models.employee.EmployeeDto;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    EmployeeDto findById(Integer id);
    void save(EmployeeDto employeeDto);
    void remove(Integer id);
}
