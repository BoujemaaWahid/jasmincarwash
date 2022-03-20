package jasmin.carwash.jsw.models.journee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jasmin.carwash.jsw.models.Vehicule.VehiculeDto;
import jasmin.carwash.jsw.models.centre.CentreBasicDto;
import lombok.Data;

@Data
public class JourneeDto implements Serializable{
    private Long id;
    private CentreBasicDto centre;
    private LocalDate date;
    private Double prixTTC;
    private Double prixHT;
    private Double primes;
    private List<VehiculeDto> vehicules;
}
