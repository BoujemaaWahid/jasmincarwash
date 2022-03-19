package jasmin.carwash.jsw.models.employee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import jasmin.carwash.jsw.models.Vehicule.VehiculeModel;
import jasmin.carwash.jsw.models.centre.CentreModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean active;
    private String prenom;
    private String nom;
    private String type;
    private String telephone;
    private String email;
    
    @OrderBy("label")       
    @OneToMany(mappedBy = "responsable")
    private List<CentreModel> assume;

    @OneToMany(mappedBy = "ajouterpar")
    private List<VehiculeModel> vehicules;
    /*
    @ManyToOne
    private Journee journee;*/
}
