package jasmin.carwash.jsw.services.formule;

import java.util.List;

import jasmin.carwash.jsw.models.formule.FormuleDto;

public interface FormuleService {
    List<FormuleDto> findAll();
    FormuleDto findById(Integer id);
    void save(FormuleDto formuleDto);
    void delete(Integer id);
}
