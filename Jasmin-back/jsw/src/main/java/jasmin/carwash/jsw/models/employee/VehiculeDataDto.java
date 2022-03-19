package jasmin.carwash.jsw.models.employee;

import java.io.Serializable;

import jasmin.carwash.jsw.models.Vehicule.VehiculeDetailDto;
import lombok.Data;

@Data
public class VehiculeDataDto implements Serializable{
    private Long id;
    private Double prixfinale;
    private Double prixinitial;
    private Double remise;
    private Double tva;
    private String categorie;
    private String matricule;
    private String marque;
    private String telephone;
    private String note;
    private VehiculeDetailDto detail;
}
