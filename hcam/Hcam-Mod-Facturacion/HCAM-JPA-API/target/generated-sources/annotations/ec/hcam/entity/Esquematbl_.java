package ec.hcam.entity;

import ec.hcam.entity.Proceditbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Esquematbl.class)
public class Esquematbl_ { 

    public static volatile SingularAttribute<Esquematbl, Integer> esidpk;
    public static volatile SingularAttribute<Esquematbl, String> esmapeotab;
    public static volatile SingularAttribute<Esquematbl, String> esnombre;
    public static volatile ListAttribute<Esquematbl, Proceditbl> proceditblList;
    public static volatile SingularAttribute<Esquematbl, String> esmapeoesq;
    public static volatile SingularAttribute<Esquematbl, String> esestado;

}