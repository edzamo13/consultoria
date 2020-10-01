package ec.hcam.entity;

import ec.hcam.entity.Areatbl;
import ec.hcam.entity.Tipostbl;
import ec.hcam.entity.Unimdeptbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Deunitbl.class)
public class Deunitbl_ { 

    public static volatile SingularAttribute<Deunitbl, String> dedepend;
    public static volatile SingularAttribute<Deunitbl, String> deestado;
    public static volatile SingularAttribute<Deunitbl, String> denombre;
    public static volatile SingularAttribute<Deunitbl, Tipostbl> tdidpk;
    public static volatile SingularAttribute<Deunitbl, Areatbl> areapk;
    public static volatile ListAttribute<Deunitbl, Unimdeptbl> unimdeptblList;
    public static volatile SingularAttribute<Deunitbl, Integer> depunpk;
    public static volatile SingularAttribute<Deunitbl, String> deardescri;

}