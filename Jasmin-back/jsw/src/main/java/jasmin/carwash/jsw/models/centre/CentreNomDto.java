package jasmin.carwash.jsw.models.centre;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CentreNomDto implements Serializable{
    @JsonProperty("value") private Integer id;
    @JsonProperty("view") private String label;
}
