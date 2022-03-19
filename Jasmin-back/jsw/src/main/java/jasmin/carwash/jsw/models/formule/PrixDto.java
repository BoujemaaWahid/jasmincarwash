package jasmin.carwash.jsw.models.formule;

import java.io.Serializable;

import lombok.Data;

@Data
public class PrixDto implements Serializable{
    private Integer id;
    private Double interieur;
    private Double exterieur;
    private Double completbasique;
    private Double lustrage;
    private Double machinelustrage;
    private Double moquettes;
    private Double sieges;
    private Double cuires;    
}
