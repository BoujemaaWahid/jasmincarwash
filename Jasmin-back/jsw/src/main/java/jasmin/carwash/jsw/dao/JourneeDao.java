package jasmin.carwash.jsw.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jasmin.carwash.jsw.models.journee.JourneeModel;

@Repository
public interface JourneeDao extends JpaSpecificationExecutor<JourneeModel>,
    PagingAndSortingRepository<JourneeModel, Long>{
    
}
