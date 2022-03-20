package jasmin.carwash.jsw.models.centre;

import java.io.Serializable;
import java.time.LocalTime;

import jasmin.carwash.jsw.models.employee.EmployeeBasicDto;
import jasmin.carwash.jsw.models.formule.FormuleBasicDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CentreDto implements Serializable{
    private Integer id;
    private String label;
    private LocalTime ouverture;
    private LocalTime fermeture;
    private Double croissancemp = .0;
    private String adresse;
    private String telephone;
    private String code;
    private EmployeeBasicDto responsable;
    private FormuleBasicDto formule;
}
