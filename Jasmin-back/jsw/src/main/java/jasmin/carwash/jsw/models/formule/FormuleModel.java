package jasmin.carwash.jsw.models.formule;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import jasmin.carwash.jsw.models.centre.CentreModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "formules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormuleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    @OrderBy("label")
    @OneToMany(mappedBy = "formule")
    private List<CentreModel> centres;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private PrixModel citadine;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private PrixModel berline;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private PrixModel monospace;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private PrixModel moto;
}
