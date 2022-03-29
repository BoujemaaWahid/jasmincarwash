package jasmin.carwash.jsw.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jasmin.carwash.jsw.models.centre.CentreModel;
import jasmin.carwash.jsw.models.employee.EmployeeModel;
import jasmin.carwash.jsw.models.formule.FormuleModel;

@Repository
public interface CentreDao extends
    PagingAndSortingRepository<CentreModel, Integer>, 
    JpaSpecificationExecutor<CentreModel>{
        
        CentreModel findByLabel(String label);
        List<CentreModel> findByResponsable(EmployeeModel responsable);
        List<CentreModel> findByFormule(FormuleModel formule);
        @Query("From CentreModel C where C.responsable = NULL")
        List<CentreModel> findByResponsableNull();
        
}
