package ec.hcam.entity;

import ec.hcam.entity.Ubicatbl;
import ec.hcam.entity.Zonastbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Zonastbl.class)
public class Zonastbl_ { 

    public static volatile SingularAttribute<Zonastbl, Integer> zonapk;
    public static volatile SingularAttribute<Zonastbl, Integer> zocodigo;
    public static volatile ListAttribute<Zonastbl, Zonastbl> zonastblList;
    public static volatile SingularAttribute<Zonastbl, String> zonombre;
    public static volatile ListAttribute<Zonastbl, Ubicatbl> ubicatblList;
    public static volatile SingularAttribute<Zonastbl, String> zoestado;
    public static volatile ListAttribute<Zonastbl, Ubicatbl> ubicatblList1;
    public static volatile SingularAttribute<Zonastbl, Zonastbl> zonZonapk;

}