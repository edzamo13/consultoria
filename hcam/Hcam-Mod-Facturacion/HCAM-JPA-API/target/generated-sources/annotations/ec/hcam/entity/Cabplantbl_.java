package ec.hcam.entity;

import ec.hcam.entity.Detplantbl;
import ec.hcam.entity.Unidmedtbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Cabplantbl.class)
public class Cabplantbl_ { 

    public static volatile SingularAttribute<Cabplantbl, Integer> anioplanilla;
    public static volatile SingularAttribute<Cabplantbl, Integer> cpidpk;
    public static volatile SingularAttribute<Cabplantbl, Integer> unidpk;
    public static volatile SingularAttribute<Cabplantbl, Integer> mesplanilla;
    public static volatile SingularAttribute<Cabplantbl, Unidmedtbl> unidmedtbl;
    public static volatile SingularAttribute<Cabplantbl, Integer> ubicapk;
    public static volatile SingularAttribute<Cabplantbl, Integer> numplanilla;
    public static volatile SingularAttribute<Cabplantbl, Integer> diaplanilla;
    public static volatile SingularAttribute<Cabplantbl, Integer> numpland;
    public static volatile SingularAttribute<Cabplantbl, Integer> diaregistro;
    public static volatile SingularAttribute<Cabplantbl, Integer> fechaReg;
    public static volatile SingularAttribute<Cabplantbl, Integer> mesregistro;
    public static volatile SingularAttribute<Cabplantbl, Integer> anioregistro;
    public static volatile SingularAttribute<Cabplantbl, String> usuarioreg;
    public static volatile ListAttribute<Cabplantbl, Detplantbl> detplantblList;
    public static volatile SingularAttribute<Cabplantbl, Character> estadoplanilla;

}