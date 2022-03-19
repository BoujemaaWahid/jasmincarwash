package jasmin.carwash.jsw.models.formule;

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
@Table(name = "prix_formules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrixModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double interieur;
    private Double exterieur;
    private Double completbasique;
    private Double moteur;
    private Double lustrage;
    private Double machinelustrage;
    private Double moquettes;
    private Double sieges;
    private Double cuires;    

}
