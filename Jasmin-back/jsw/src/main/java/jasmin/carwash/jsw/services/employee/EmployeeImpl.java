package jasmin.carwash.jsw.services.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jasmin.carwash.jsw.dao.CentreDao;
import jasmin.carwash.jsw.dao.EmployeeDao;
import jasmin.carwash.jsw.models.centre.CentreModel;
import jasmin.carwash.jsw.models.employee.EmployeeDto;
import jasmin.carwash.jsw.models.employee.EmployeeModel;

@Service
public class EmployeeImpl implements EmployeeService{
    @Autowired EmployeeDao employeeDao;
    @Autowired CentreDao centreDao;
    @Autowired ModelMapper mapper;

    @Override
    public List<EmployeeDto> findAll() {
        List<EmployeeDto> employees = new ArrayList<>();
        employeeDao.findAll().forEach(employeeEntity->{
            employees.add( mapper.map(employeeEntity, EmployeeDto.class) );
        });
        return employees;
    }

    @Override
    public EmployeeDto findById(Integer id) {
        Optional<EmployeeModel> e = employeeDao.findById(id);
        return e.isPresent() ? mapper.map(e.get(), EmployeeDto.class) : null;
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        EmployeeModel model = mapper.map(employeeDto, EmployeeModel.class);        
        
        model = employeeDao.save(model);
    
        if( employeeDto.getAssume() != null ){
            List<Integer> centres_ids = employeeDto.getAssume().stream().map(e->e.getId()).collect(Collectors.toList());
            List<CentreModel> remove_ids = centreDao.findByResponsable(model).stream().filter(e->!centres_ids.contains(e.getId()))
            .map(e->{
                e.setResponsable(null);
                return e;
            }).collect(Collectors.toList());
            AtomicReference<EmployeeModel> responsable = new AtomicReference<>(model);
            List<CentreModel> centres = new ArrayList<>();
            centres.addAll(remove_ids);
            centreDao.findAllById(centres_ids).forEach(centre->{
                centre.setResponsable( responsable.get() );
                centres.add(centre);
            });
            centreDao.saveAll(centres);
        }
    }

    @Override
    public void remove(Integer id) {
        employeeDao.deleteById(id);
    }
}
