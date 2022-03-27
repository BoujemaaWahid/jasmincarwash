package jasmin.carwash.jsw.services.centre;

import java.util.List;

import jasmin.carwash.jsw.models.centre.CentreDto;
import jasmin.carwash.jsw.models.centre.CentreNomDto;

public interface CentreService {
    List<CentreDto> findAll();
    List<CentreNomDto> findWithoutResponsable();
    void save(CentreDto centreDto);
    void remove(Integer id);
    CentreDto findByLabel(String label);
    CentreDto findById(Integer id);
    List<String> findLabelHavingMatch(String match);
}
