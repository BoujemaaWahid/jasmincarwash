package jasmin.carwash.jsw.models.Vehicule;

import java.io.Serializable;
import java.time.LocalTime;

import jasmin.carwash.jsw.models.journee.JourneeBasicDto;
import lombok.Data;

@Data
public class VehiculeDto implements Serializable{
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
    private VehiculeDetailDto detail;
    private AjouterParDto ajouterpar;
    private JourneeBasicDto journee;
}
