package ec.hcam.entity;

import ec.hcam.entity.Cabplantbl;
import ec.hcam.entity.Histclitbl;
import ec.hcam.entity.Ubicatbl;
import ec.hcam.entity.UnidmedtblPK;
import ec.hcam.entity.Unimdeptbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Unidmedtbl.class)
public class Unidmedtbl_ { 

    public static volatile ListAttribute<Unidmedtbl, Histclitbl> histclitblList;
    public static volatile SingularAttribute<Unidmedtbl, String> unicom;
    public static volatile SingularAttribute<Unidmedtbl, String> unestado;
    public static volatile SingularAttribute<Unidmedtbl, UnidmedtblPK> unidmedtblPK;
    public static volatile SingularAttribute<Unidmedtbl, String> uncodigo;
    public static volatile SingularAttribute<Unidmedtbl, Date> unfeccre;
    public static volatile SingularAttribute<Unidmedtbl, String> unnombre;
    public static volatile SingularAttribute<Unidmedtbl, Integer> unnivel;
    public static volatile ListAttribute<Unidmedtbl, Cabplantbl> cabplantblList;
    public static volatile SingularAttribute<Unidmedtbl, Date> unfecmod;
    public static volatile ListAttribute<Unidmedtbl, Unimdeptbl> unimdeptblList;
    public static volatile SingularAttribute<Unidmedtbl, String> undirec;
    public static volatile SingularAttribute<Unidmedtbl, Ubicatbl> ubicpk;

}