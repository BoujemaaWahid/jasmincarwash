package jasmin.carwash.jsw.models.formule;

import java.io.Serializable;
import java.util.List;

import jasmin.carwash.jsw.models.centre.CentreBasicDto;
import lombok.Data;

@Data
public class FormuleDto implements Serializable{
    private Integer id;
    private String label;
    private List<CentreBasicDto> centres;
    private PrixDto citadine;
    private PrixDto berline;
    private PrixDto monospace;
    private PrixDto moto;
}
