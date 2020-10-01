package ec.hcam.entity;

import ec.hcam.entity.Reglastbl;
import ec.hcam.entity.Servtbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Parmfactbl.class)
public class Parmfactbl_ { 

    public static volatile SingularAttribute<Parmfactbl, String> panombre;
    public static volatile SingularAttribute<Parmfactbl, String> padescripc;
    public static volatile SingularAttribute<Parmfactbl, Date> pafechafin;
    public static volatile SingularAttribute<Parmfactbl, String> padetalle;
    public static volatile SingularAttribute<Parmfactbl, Servtbl> seidpk;
    public static volatile SingularAttribute<Parmfactbl, Integer> paidpk;
    public static volatile SingularAttribute<Parmfactbl, String> pacodigo;
    public static volatile SingularAttribute<Parmfactbl, String> paestado;
    public static volatile SingularAttribute<Parmfactbl, Date> pafechaini;
    public static volatile ListAttribute<Parmfactbl, Reglastbl> reglastblList;
    public static volatile SingularAttribute<Parmfactbl, String> patipcobro;

}