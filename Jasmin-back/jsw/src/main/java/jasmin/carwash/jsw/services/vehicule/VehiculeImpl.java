package jasmin.carwash.jsw.services.vehicule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jasmin.carwash.jsw.dao.JourneeDao;
import jasmin.carwash.jsw.dao.VehiculeDao;
import jasmin.carwash.jsw.models.Vehicule.VehiculeDto;
import jasmin.carwash.jsw.models.Vehicule.VehiculeModel;

@Service
public class VehiculeImpl implements VehiculeService{
    @Autowired VehiculeDao vehiculeDao;
    @Autowired JourneeDao journeeDao;
    @Autowired ModelMapper mapper;

    @Override
    public List<VehiculeDto> findAll() {
        List<VehiculeDto> vehicules = new ArrayList<>();
        vehiculeDao.findAll().forEach(v->vehicules.add( mapper.map(v, VehiculeDto.class)));
        return vehicules;
    }
    
    @Override
    public VehiculeDto findById(Long id) {
        Optional<VehiculeModel> v = vehiculeDao.findById(id);
        return v.isPresent() ? mapper.map(v.get(), VehiculeDto.class) : null;
    }

    @Override
    public void save(VehiculeDto vehiculeDto) {
        VehiculeModel model = mapper.map(vehiculeDto, VehiculeModel.class);
        vehiculeDao.save( model );
    }
}
