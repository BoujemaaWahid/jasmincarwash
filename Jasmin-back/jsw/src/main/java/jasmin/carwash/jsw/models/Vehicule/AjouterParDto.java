package jasmin.carwash.jsw.models.Vehicule;

import java.io.Serializable;

import lombok.Data;

@Data
public class AjouterParDto implements Serializable{
    private Integer id;
    private String prenom;
    private String nom;
}
