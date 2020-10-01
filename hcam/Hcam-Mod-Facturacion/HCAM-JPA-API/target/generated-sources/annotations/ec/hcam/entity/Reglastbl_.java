package ec.hcam.entity;

import ec.hcam.entity.Formutbl;
import ec.hcam.entity.Parmfactbl;
import ec.hcam.entity.Reglastbl;
import ec.hcam.entity.Tipoacrtbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Reglastbl.class)
public class Reglastbl_ { 

    public static volatile SingularAttribute<Reglastbl, String> redescripc;
    public static volatile SingularAttribute<Reglastbl, Date> refechamod;
    public static volatile SingularAttribute<Reglastbl, String> reestado;
    public static volatile SingularAttribute<Reglastbl, Parmfactbl> paidpk;
    public static volatile SingularAttribute<Reglastbl, Date> refechacre;
    public static volatile SingularAttribute<Reglastbl, String> recalculo;
    public static volatile SingularAttribute<Reglastbl, Reglastbl> regReidpk;
    public static volatile SingularAttribute<Reglastbl, String> reformula;
    public static volatile SingularAttribute<Reglastbl, Tipoacrtbl> taidpk;
    public static volatile SingularAttribute<Reglastbl, String> retipo;
    public static volatile SingularAttribute<Reglastbl, String> reformula1;
    public static volatile SingularAttribute<Reglastbl, Integer> reidpk;
    public static volatile SingularAttribute<Reglastbl, String> renombre;
    public static volatile ListAttribute<Reglastbl, Formutbl> formutblList;
    public static volatile ListAttribute<Reglastbl, Reglastbl> reglastblList;

}