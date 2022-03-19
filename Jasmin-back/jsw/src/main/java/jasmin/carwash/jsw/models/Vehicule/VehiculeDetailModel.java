package jasmin.carwash.jsw.models.Vehicule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicules_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehiculeDetailModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean interieur;
    private Boolean exterieur;
    private Boolean completbasique;
    private Boolean moteur;
    private Boolean lustrage;
    private Boolean machinelustrage;
    private Boolean moquettes;
    private Boolean sieges;
    private Boolean cuires;
}
