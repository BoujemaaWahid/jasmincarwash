package jasmin.carwash.jsw.models.employee;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeBasicDto implements Serializable{
    private Integer id;
    private boolean active;
    private String prenom;
    private String nom;
    private String type;
    private String telephone;
    private String email;
}
