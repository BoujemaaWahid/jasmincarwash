package jasmin.carwash.jsw.services.centre;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jasmin.carwash.jsw.dao.CentreDao;
import jasmin.carwash.jsw.models.centre.CentreDto;
import jasmin.carwash.jsw.models.centre.CentreModel;
import jasmin.carwash.jsw.services.centre.specifications.WithLabelLike;

@Service
public class CentreImpl implements CentreService{
    @Autowired CentreDao centreDao;
    @Autowired ModelMapper mapper;

    @Override
    public List<CentreDto> findAll() {
        List<CentreDto> centres = new ArrayList<>();
        centreDao.findAll().forEach(centreEntity->{
            centres.add( mapper.map(centreEntity, CentreDto.class) );
        });
        return centres;
    }

    @Override
    public void save(CentreDto centreDto) {
        CentreModel centre = mapper.map(centreDto, CentreModel.class);
        centreDao.save(centre);
    }

    @Override
    public void remove(Integer id) {
        centreDao.deleteById(id);
    }

    @Override
    public CentreDto findByLabel(String label) {
        CentreModel centre = centreDao.findByLabel(label);
        return centre == null ? null : mapper.map(centre, CentreDto.class);
    }

    @Override
    public List<String> findLabelHavingMatch(String label) {
        List<String> centres = new ArrayList<>();
        centreDao.findAll(WithLabelLike.getPredicate(label)).forEach(centreEntity->{
            centres.add( mapper.map(centreEntity, CentreDto.class).getAdresse() );
        });
        return centres;
    }
}
