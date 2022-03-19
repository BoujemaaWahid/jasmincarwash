package jasmin.carwash.jsw.services.vehicule;

import java.util.List;

import jasmin.carwash.jsw.models.Vehicule.VehiculeDto;

public interface VehiculeService {
    List<VehiculeDto> findAll();
    VehiculeDto findById(Long id);
    void save(VehiculeDto vehiculeDto);
}
