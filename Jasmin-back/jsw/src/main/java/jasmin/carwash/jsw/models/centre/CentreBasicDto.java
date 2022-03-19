package jasmin.carwash.jsw.models.centre;

import java.io.Serializable;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CentreBasicDto implements Serializable{
    private Integer id;
    private String label;
    private LocalTime ouverture;
    private LocalTime fermeture;
    private String adresse;
}
