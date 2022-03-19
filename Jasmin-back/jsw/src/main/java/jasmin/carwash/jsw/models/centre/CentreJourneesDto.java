package jasmin.carwash.jsw.models.centre;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import jasmin.carwash.jsw.models.employee.EmployeeBasicDto;
import jasmin.carwash.jsw.models.formule.FormuleBasicDto;
import jasmin.carwash.jsw.models.journee.JourneeDto;
import lombok.Data;

@Data
public class CentreJourneesDto implements Serializable{
    private Integer id;
    private String label;
    private LocalTime ouverture;
    private LocalTime fermeture;
    private String adresse;
    private EmployeeBasicDto responsable;
    private FormuleBasicDto formule;
    private List<JourneeDto> journees;
}
