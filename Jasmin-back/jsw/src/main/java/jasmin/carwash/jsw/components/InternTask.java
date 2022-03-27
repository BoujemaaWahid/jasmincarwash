package jasmin.carwash.jsw.components;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jasmin.carwash.jsw.dao.CentreDao;
import jasmin.carwash.jsw.models.centre.CentreModel;

@Component
public class InternTask {
    
    @Autowired CentreDao centreDao;

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 12, initialDelay = 1000)
    public void updateCroissanceCentreMp(){
        List<CentreModel> centres = new ArrayList<>();
        centreDao.findAll().forEach(centres::add);
        for(CentreModel c: centres)
            c.setCroissancemp( c.getCroissancemp() + 2 );
        centreDao.saveAll(centres);
    }
}
