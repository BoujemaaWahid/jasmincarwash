package jasmin.carwash.jsw.models.journee;

import java.io.Serializable;
import java.time.LocalDate;

import jasmin.carwash.jsw.models.centre.CentreBasicDto;
import lombok.Data;

@Data
public class JourneeBasicDto implements Serializable{
    private Long id;
    private CentreBasicDto centre;
    private LocalDate date;
    private Double prixTTC;
    private Double prixHT;
    private Double primes;
}
