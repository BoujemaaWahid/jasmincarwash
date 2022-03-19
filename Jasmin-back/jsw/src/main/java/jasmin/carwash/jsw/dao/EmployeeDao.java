package jasmin.carwash.jsw.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jasmin.carwash.jsw.models.employee.EmployeeModel;

@Repository
public interface EmployeeDao extends 
    JpaSpecificationExecutor<EmployeeModel>,
    PagingAndSortingRepository<EmployeeModel, Integer>{
    
}
