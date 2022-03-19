package jasmin.carwash.jsw.services.centre;

import java.util.List;

import jasmin.carwash.jsw.models.centre.CentreDto;

public interface CentreService {
    List<CentreDto> findAll();
    void save(CentreDto centreDto);
    void remove(Integer id);
    CentreDto findByLabel(String label);
    List<String> findLabelHavingMatch(String match);
}
