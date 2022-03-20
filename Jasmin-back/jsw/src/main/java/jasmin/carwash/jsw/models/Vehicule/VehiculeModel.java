package jasmin.carwash.jsw.models.Vehicule;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jasmin.carwash.jsw.models.employee.EmployeeModel;
import jasmin.carwash.jsw.models.journee.JourneeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehiculeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double prixfinale;
    private Double prixinitial;
    private Double remise;
    private Double tva;
    
    private LocalTime entree;
    private String categorie;
    private String matricule;
    private String marque;
    private String telephone;

    private String note;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private VehiculeDetailModel detail;

    @ManyToOne
    @JoinColumn(name = "ajouter_par", referencedColumnName = "id")
    private EmployeeModel ajouterpar;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "journee", referencedColumnName = "id")
    private JourneeModel journee;
}
