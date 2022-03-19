package jasmin.carwash.jsw.models.formule;

import java.io.Serializable;

import lombok.Data;

@Data
public class FormuleBasicDto implements Serializable{
    private Integer id;
    private String label;
    private PrixDto citadine;
    private PrixDto berline;
    private PrixDto monospace; 
    private PrixDto moto;   
}
