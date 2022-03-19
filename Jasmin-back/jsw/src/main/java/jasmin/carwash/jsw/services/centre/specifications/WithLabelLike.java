package jasmin.carwash.jsw.services.centre.specifications;

import org.springframework.data.jpa.domain.Specification;

import jasmin.carwash.jsw.models.centre.CentreModel;

public class WithLabelLike {
    public static Specification<CentreModel> getPredicate(String label){
        return (root, cq, cb)->{
            return cb.like(cb.lower(root.get("label")), "%"+label.toLowerCase()+"%");
        };
    }
}
