package ec.hcam.entity;

import ec.hcam.entity.Consultbl;
import ec.hcam.entity.Parmfactbl;
import ec.hcam.entity.Unimdeptbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Servtbl.class)
public class Servtbl_ { 

    public static volatile SingularAttribute<Servtbl, String> seobserv;
    public static volatile ListAttribute<Servtbl, Parmfactbl> parmfactblList;
    public static volatile SingularAttribute<Servtbl, Unimdeptbl> unimpk;
    public static volatile SingularAttribute<Servtbl, Integer> seidpk;
    public static volatile SingularAttribute<Servtbl, String> senombre;
    public static volatile SingularAttribute<Servtbl, String> seestado;
    public static volatile SingularAttribute<Servtbl, String> secodigo;
    public static volatile ListAttribute<Servtbl, Consultbl> consultblList;

}