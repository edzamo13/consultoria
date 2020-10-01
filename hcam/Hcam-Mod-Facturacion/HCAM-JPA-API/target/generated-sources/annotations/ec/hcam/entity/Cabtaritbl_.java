package ec.hcam.entity;

import ec.hcam.entity.Tarifaftbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Cabtaritbl.class)
public class Cabtaritbl_ { 

    public static volatile SingularAttribute<Cabtaritbl, Integer> ctidpk;
    public static volatile SingularAttribute<Cabtaritbl, String> tanombre;
    public static volatile SingularAttribute<Cabtaritbl, String> taestado;
    public static volatile SingularAttribute<Cabtaritbl, Integer> tanivelum;
    public static volatile ListAttribute<Cabtaritbl, Tarifaftbl> tarifaftblList;
    public static volatile SingularAttribute<Cabtaritbl, String> tadescripc;
    public static volatile SingularAttribute<Cabtaritbl, Integer> taano;

}