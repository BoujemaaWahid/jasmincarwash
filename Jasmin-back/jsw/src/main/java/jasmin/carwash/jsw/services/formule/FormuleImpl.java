package jasmin.carwash.jsw.services.formule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jasmin.carwash.jsw.dao.CentreDao;
import jasmin.carwash.jsw.dao.FormuleDao;
import jasmin.carwash.jsw.models.centre.CentreModel;
import jasmin.carwash.jsw.models.formule.FormuleDto;
import jasmin.carwash.jsw.models.formule.FormuleModel;

@Service
public class FormuleImpl implements FormuleService{
    @Autowired FormuleDao formuleDao;
    @Autowired CentreDao centreDao;
    @Autowired ModelMapper mapper;

    @Override
    public List<FormuleDto> findAll() {
        List<FormuleDto> formules = new ArrayList<>();
        formuleDao.findAll().forEach(f->formules.add( mapper.map(f, FormuleDto.class)));
        return formules;
    }

    @Override
    public FormuleDto findById(Integer id) {
        Optional<FormuleModel> e = formuleDao.findById(id);
        return e.isPresent() ? mapper.map(e.get(), FormuleDto.class) : null;
    }

    @Override
    public void save(FormuleDto formuleDto) {
        FormuleModel model = mapper.map(formuleDto, FormuleModel.class);
        model = formuleDao.save(model);
        if( formuleDto.getCentres() == null ) return;
        List<Integer> centres_ids = formuleDto.getCentres().stream().map(e->e.getId()).collect(Collectors.toList());
        List<CentreModel> remove_ids = centreDao.findByFormule(model).stream().filter(e->!centres_ids.contains(e.getId()))
        .map(e->{
            e.setFormule(null);
            return e;
        }).collect(Collectors.toList());
        AtomicReference<FormuleModel> formule = new AtomicReference<>(model);
        List<CentreModel> centres = new ArrayList<>();
        centres.addAll(remove_ids);
        centreDao.findAllById(centres_ids).forEach(centre->{
            centre.setFormule(formule.get());
            centres.add(centre);
        });
        centreDao.saveAll(centres);
    }

    @Override
    public void delete(Integer id) {
        formuleDao.deleteById(id);
    }
}
