package jasmin.carwash.jsw.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jasmin.carwash.jsw.models.Vehicule.VehiculeModel;

@Repository
public interface VehiculeDao extends JpaSpecificationExecutor<VehiculeModel>,
    PagingAndSortingRepository<VehiculeModel, Long>{
    
}
