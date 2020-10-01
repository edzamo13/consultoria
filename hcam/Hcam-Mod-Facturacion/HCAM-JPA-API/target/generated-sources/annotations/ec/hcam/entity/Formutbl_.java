package ec.hcam.entity;

import ec.hcam.entity.Reglastbl;
import ec.hcam.entity.Repatbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Formutbl.class)
public class Formutbl_ { 

    public static volatile SingularAttribute<Formutbl, String> nombform;
    public static volatile SingularAttribute<Formutbl, String> valorform;
    public static volatile SingularAttribute<Formutbl, String> calcuform;
    public static volatile SingularAttribute<Formutbl, Reglastbl> reidpk;
    public static volatile SingularAttribute<Formutbl, String> estdform;
    public static volatile SingularAttribute<Formutbl, Integer> formupk;
    public static volatile ListAttribute<Formutbl, Repatbl> repatblList;

}