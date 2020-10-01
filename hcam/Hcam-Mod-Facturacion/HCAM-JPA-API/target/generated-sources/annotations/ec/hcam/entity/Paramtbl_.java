package ec.hcam.entity;

import ec.hcam.entity.Proceditbl;
import ec.hcam.entity.Repatbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Paramtbl.class)
public class Paramtbl_ { 

    public static volatile SingularAttribute<Paramtbl, String> pamvalor;
    public static volatile SingularAttribute<Paramtbl, Proceditbl> prprocedpk;
    public static volatile SingularAttribute<Paramtbl, String> pamnombre;
    public static volatile SingularAttribute<Paramtbl, String> pamtipoval;
    public static volatile SingularAttribute<Paramtbl, String> pamestado;
    public static volatile ListAttribute<Paramtbl, Repatbl> repatblList;
    public static volatile SingularAttribute<Paramtbl, Integer> pamidpk;

}