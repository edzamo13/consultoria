package ec.hcam.entity;

import ec.hcam.entity.Ubicatbl;
import ec.hcam.entity.Unidmedtbl;
import ec.hcam.entity.Zonastbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Ubicatbl.class)
public class Ubicatbl_ { 

    public static volatile SingularAttribute<Ubicatbl, String> ubestado;
    public static volatile SingularAttribute<Ubicatbl, Zonastbl> zonapk;
    public static volatile SingularAttribute<Ubicatbl, String> ubnombre;
    public static volatile ListAttribute<Ubicatbl, Unidmedtbl> unidmedtblList;
    public static volatile SingularAttribute<Ubicatbl, Integer> ubcodigo;
    public static volatile ListAttribute<Ubicatbl, Ubicatbl> ubicatblList;
    public static volatile SingularAttribute<Ubicatbl, Zonastbl> zonZonapk;
    public static volatile SingularAttribute<Ubicatbl, Integer> ubicpk;
    public static volatile SingularAttribute<Ubicatbl, Ubicatbl> ubiUbicpk;

}