package jasmin.carwash.jsw.models.journee;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jasmin.carwash.jsw.models.Vehicule.VehiculeModel;
import jasmin.carwash.jsw.models.centre.CentreModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "journees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JourneeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "centre", referencedColumnName = "id")
    private CentreModel centre;

    private LocalDate date;

    private Double prixTTC;
    private Double prixHT;

    @OneToMany(mappedBy = "journee")
    private List<VehiculeModel> vehicules;
}
