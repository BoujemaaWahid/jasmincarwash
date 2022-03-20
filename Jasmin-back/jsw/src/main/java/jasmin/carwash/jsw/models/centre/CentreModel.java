package jasmin.carwash.jsw.models.centre;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jasmin.carwash.jsw.models.employee.EmployeeModel;
import jasmin.carwash.jsw.models.formule.FormuleModel;
import jasmin.carwash.jsw.models.journee.JourneeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "centres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CentreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true, nullable = false,length = 100)
    private String label;

    @Column(columnDefinition = "Decimal(10,2) default '0.0'")
    private Double croissancemp;

    private LocalTime ouverture;
    private LocalTime fermeture;

    @Column(nullable = false, length = 200)
    private String adresse;


    private String telephone;
    private String code;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "responsable", referencedColumnName = "id")
    private EmployeeModel responsable;


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "formule", referencedColumnName = "id")
    private FormuleModel formule;

    @OneToMany(mappedBy = "centre")
    private List<JourneeModel> journees;
}
