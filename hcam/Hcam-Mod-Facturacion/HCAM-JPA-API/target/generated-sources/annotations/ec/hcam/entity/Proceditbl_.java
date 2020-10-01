package ec.hcam.entity;

import ec.hcam.entity.Esquematbl;
import ec.hcam.entity.Paramtbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Proceditbl.class)
public class Proceditbl_ { 

    public static volatile SingularAttribute<Proceditbl, Esquematbl> esidpk;
    public static volatile SingularAttribute<Proceditbl, Integer> prprocedpk;
    public static volatile SingularAttribute<Proceditbl, String> prnombre;
    public static volatile SingularAttribute<Proceditbl, String> prestado;
    public static volatile ListAttribute<Proceditbl, Paramtbl> paramtblList;
    public static volatile SingularAttribute<Proceditbl, String> prcampo;
    public static volatile SingularAttribute<Proceditbl, String> prdescripc;
    public static volatile SingularAttribute<Proceditbl, String> prsql;

}