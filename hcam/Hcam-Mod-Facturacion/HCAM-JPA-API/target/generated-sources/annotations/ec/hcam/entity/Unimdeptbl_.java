package ec.hcam.entity;

import ec.hcam.entity.Deunitbl;
import ec.hcam.entity.Servtbl;
import ec.hcam.entity.Unidmedtbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T10:27:54")
@StaticMetamodel(Unimdeptbl.class)
public class Unimdeptbl_ { 

    public static volatile SingularAttribute<Unimdeptbl, String> estado;
    public static volatile SingularAttribute<Unimdeptbl, Integer> unimpk;
    public static volatile SingularAttribute<Unimdeptbl, Date> fechaasig;
    public static volatile SingularAttribute<Unimdeptbl, Deunitbl> depunpk;
    public static volatile SingularAttribute<Unimdeptbl, Unidmedtbl> unidmedtbl;
    public static volatile ListAttribute<Unimdeptbl, Servtbl> servtblList;

}