package jasmin.carwash.jsw.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jasmin.carwash.jsw.models.formule.FormuleModel;

@Repository
public interface FormuleDao extends JpaSpecificationExecutor<FormuleModel>,
    PagingAndSortingRepository<FormuleModel, Integer>{
    
}
