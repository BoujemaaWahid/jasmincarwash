package jasmin.carwash.jsw.models.Vehicule;

import java.io.Serializable;

import lombok.Data;

@Data
public class VehiculeDetailDto implements Serializable{
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
