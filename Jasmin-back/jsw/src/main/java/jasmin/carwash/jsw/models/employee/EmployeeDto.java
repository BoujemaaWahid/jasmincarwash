package jasmin.carwash.jsw.models.employee;

import java.io.Serializable;
import java.util.List;
import jasmin.carwash.jsw.models.centre.CentreBasicDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto implements Serializable{
    private Integer id;

    private boolean active;
    private String prenom;
    private String nom;
    private String type;
    private String telephone;
    private String email;
    
    private List<CentreBasicDto> assume;
    private List<VehiculeDataDto> vehicules;
}
